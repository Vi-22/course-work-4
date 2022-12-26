package ru.viktoria.cw4.entity;


import jakarta.persistence.*;
import ru.viktoria.cw4.db.GeneralDao;

import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "tb_groups")
public class Group extends GeneralDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_number")
    private int number;
    @OneToMany(mappedBy = "group")
    @JoinColumn(name = "clamber_id")
    private ArrayList<Climber> climbers;
    @NotNull
    private boolean isOpen;
    @NotNull
    private int participantsLimit;
    @NotNull
    private Calendar climbDate;
    @NotNull
    @OneToOne(mappedBy = "group")
    @JoinColumn(name = "mountain_id")
    private Mountain mountain;

    public Group() {
    }

    public Group(int participantsLimit, Calendar climbDate, Mountain mountain) {
        setParticipantsLimit(participantsLimit);
        setClimbDate(climbDate);
        setMountain(mountain);
        this.climbers = new ArrayList<>();
        isOpen();
    }

    public  ArrayList<Climber> getClimbers() {
        return climbers;
    }

    public void setClimbers(ArrayList<Climber>  clambers) {
        this.climbers = clambers;
    }

    public boolean isOpen() {
        this.isOpen = (this.climbers == null || this.climbers.size() < this.participantsLimit);
        return isOpen;
    }

    public int getParticipantsLimit() {
        return participantsLimit;
    }

    public void setParticipantsLimit(int participantsLimit) {
        if (participantsLimit==0)
            throw new IllegalArgumentException("Количество участников должно быть больше 0");
        this.participantsLimit = participantsLimit;
    }

    public Calendar getClimbDate() {
        return climbDate;
    }

    public void setClimbDate(Calendar climbDate) {
        if (climbDate==null||climbDate.before(Calendar.getInstance()))
            throw new IllegalArgumentException("Нельзя установить дату в прошлом");
        this.climbDate = climbDate;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Group{" +
                "number=" + number +
                ", climbers=" + climbers +
                ", isOpen=" + isOpen +
                ", participantsLimit=" + participantsLimit +
                ", climbDate=" + climbDate +
                ", mountain=" + mountain.getName() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return number == group.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public void addClimber(Climber climber) {
        if(climber.getGroup()==this) {
            System.out.println("Альпинист уже был добавлен в эту группу ранее");
        } else if (isOpen) {
            climbers.add(climber);
            climber.setGroup(this);
        } else {
            System.out.println("В этой группе больше нет мест. Пользователь не добавлен");
        }
    }
    public void removeClimber(Climber climber) {
        this.climbers.remove(climber);
        this.climbers.trimToSize();
        climber.setGroup(null);
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
        mountain.setGroup(this);
    }
}

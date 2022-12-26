package ru.viktoria.cw4.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;
import ru.viktoria.cw4.db.GeneralDao;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "tb_clambers")
public class Climber extends GeneralDao<Climber, Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clamber_id")
    private int id;
    @NotNull
    @Length(min = 3)
    @Column(nullable = false)
    private String name;
    @NotNull
    @Length(min = 5)
    @Column(nullable = false)
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_number")
    private Group group;

    public Climber() {
    }

    public Climber(String name, String address) {
        setName(name);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя должно содержать не менее 3 символов");
        }
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.length() < 5) {
            throw new IllegalArgumentException("Адрес должен содержать не менее 5 символов");
        }
        this.address = address;
    }

    public Group getGroup() {
        return group;
    }

    protected void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Climber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Climber climber = (Climber) o;
        return id == climber.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

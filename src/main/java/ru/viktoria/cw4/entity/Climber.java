package ru.viktoria.cw4.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "tb_clambers")
public class Climber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @NotNull
    @Length(min = 3)
    @Column(nullable = false)
    private String name;
    @NotNull
    @Length(min = 5)
    @Column(nullable = false)
    private String address;
    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(name = "tb_clambers_groups")
    private ArrayList<Group> groups = new ArrayList<>();

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

    public ArrayList<Group> getGroups() {
        return groups;
    }

    protected void setGroup(Group group) {
        this.groups.add(group);
    }
    protected void removeGroup(Group group) {
        this.groups.remove(group);
        this.groups.trimToSize();
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

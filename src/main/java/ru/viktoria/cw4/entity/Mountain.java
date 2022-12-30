package ru.viktoria.cw4.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "tb_mountains")
public class Mountain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int id;
    @NotNull
    @Length(min = 4)
    @Column(unique = true, nullable = false)
    private String name;
    @NotNull
    @Length(min = 4)
    private String country;
    @NotNull
    @Length(min = 100)
    private int height;

    @OneToMany(mappedBy = "mountain")
    private ArrayList<Group> groups = new ArrayList<>();


    public Mountain() {
    }

    public Mountain(String name, String country, int height) {
        setName(name);
        setCountry(country);
        setHeight(height);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 4)
            throw new IllegalArgumentException("Название горы должно содержать не менее 4 символов");
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country.length() < 4)
            throw new IllegalArgumentException("Название страны должно содержать не менее 4 символов");
        this.country = country;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 100)
            throw new IllegalArgumentException("Высота горы должна быть не менее 100м");
        this.height = height;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mountain mountain = (Mountain) o;
        return getId() == mountain.getId();
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", height=" + height +
                ", group=" + groups.toString() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

package com.somecompany.entity;

import javax.persistence.*;

@Entity
@Table(name = "computercomponent")
public class ComputerComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_component")
    private int numberComponent;

    @Column(name = "necessary", columnDefinition = "BOOLEAN")
    private boolean necessary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberComponent() {
        return numberComponent;
    }

    public void setNumberComponent(int numberComponent) {
        this.numberComponent = numberComponent;
    }

    public boolean isNecessary() {
        return necessary;
    }

    public void setNecessary(boolean necessary) {
        this.necessary = necessary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComputerComponent that = (ComputerComponent) o;

        if (id != that.id) return false;
        if (numberComponent != that.numberComponent) return false;
        if (necessary != that.necessary) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + numberComponent;
        result = 31 * result + (necessary ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ComputerComponent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberComponent=" + numberComponent +
                ", necessary=" + necessary +
                '}';
    }
}

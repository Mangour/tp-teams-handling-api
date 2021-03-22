package fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity;

import javax.persistence.*;
@Entity
@Table(name="team")
public class TeamEntity {
    @Column
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String slogan;

    public TeamEntity() {
    }

    public TeamEntity(String name, String slogan) {
        this.name = name;
        this.slogan = slogan;
    }

    public Long  getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    @Override
    public String toString() {
        return "TeamEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slogan='" + slogan + '\'' +
                '}';
    }
    public TeamEntity id(Long id) {
        this.id = id;
        return this;
    }

    public TeamEntity name(String name) {
        this.name = name;
        return this;
    }

    public TeamEntity slogan(String slogan) {
        this.slogan = slogan;
        return this;
    }
}

package fr.epsi.arras.tp.course.tpcourseapi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", fetch = FetchType.LAZY)
    private List<Chapter> chapters;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}

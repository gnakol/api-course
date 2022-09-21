package fr.epsi.arras.tp.course.tpcourseapi.controller;

import fr.epsi.arras.tp.course.tpcourseapi.entity.Course;
import fr.epsi.arras.tp.course.tpcourseapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/v1/courses", produces = "application/json")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/v1/courses/create",
            produces = "application/json",
            consumes = "application/json"
    )
    public Course createCourse(@RequestBody Course course)
    {
        return this.courseRepository.save(course);
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "v1/courses/{id}",
            produces = "application/json")
    public Course getChapter(@PathVariable(value = "id") Long id)
    {
        return courseRepository.findById(id).orElseThrow();
    }

    /*@RequestMapping(
            method = RequestMethod.PUT,
            value = "v1/courses/update",
            produces = "application/json",
            consumes = "application/json"
    )
    public Course updateCourse(long id_course, @RequestBody Course course) {

        return courseRepository.findById(id_course)
                .map(p->{
                    p.setName(course.getName());
                    p.setDescritpion(course.getDescription());
                    return courseRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("desoler le cours que vous chercher n'existe pas"));

    }*/
}

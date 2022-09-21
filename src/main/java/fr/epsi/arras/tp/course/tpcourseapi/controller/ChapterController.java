package fr.epsi.arras.tp.course.tpcourseapi.controller;

import fr.epsi.arras.tp.course.tpcourseapi.entity.Chapter;
import fr.epsi.arras.tp.course.tpcourseapi.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChapterController {
    @Autowired
    private ChapterRepository chapterRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/v1/chapters", produces = "application/json")
    public List<Chapter> getChapters(){
        return chapterRepository.findAll();
    }

    @PostMapping(value = "/v1/chapters/create", produces = "application/json", consumes = "application/json")
    public Chapter createChapter(@RequestBody Chapter chapter){
        return chapterRepository.save(chapter);
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "v1/chapters/{id}",
            produces = "application/json")
    public Chapter getChapter(@PathVariable(value = "id") Long id)
    {
        return chapterRepository.findById(id).orElseThrow();
    }


}

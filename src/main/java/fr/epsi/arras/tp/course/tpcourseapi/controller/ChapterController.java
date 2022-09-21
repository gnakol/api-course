package fr.epsi.arras.tp.course.tpcourseapi.controller;

import fr.epsi.arras.tp.course.tpcourseapi.entity.Chapter;
import fr.epsi.arras.tp.course.tpcourseapi.repository.ChapterRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
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

    @RequestMapping(method = RequestMethod.PUT, value = "v1/chapters/{id}/modify")
    public Chapter modifyChapter(@PathVariable Long id, @RequestBody Chapter chapter)
    {
        Chapter theChapter = chapterRepository.findById(id).orElseThrow();
        System.out.println(chapter);
        if(chapter.getContent() != null){
            theChapter.setContent(chapter.getContent());
        }

        theChapter.setTitle(chapter.getTitle());
        theChapter.setCourse(chapter.getCourse());
        return chapterRepository.save(theChapter);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/v1/chapters/{id}/delete")
    public void deleteChapter(@PathVariable Long id)
    {
        Chapter chapter = chapterRepository.findById(id).orElseThrow();
        if(chapter.getId() != null)
        {
            chapterRepository.delete(chapter);
        }
    }


}

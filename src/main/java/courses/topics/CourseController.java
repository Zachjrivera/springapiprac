package courses.topics;

import creatingmavenspring.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


    @RequestMapping(value = "/topics/{id}/courses",method = RequestMethod.GET)
    public List<Course> getAllCourses(@PathVariable String id){
        
       return courseService.getAllCourses(id);
    }


    @RequestMapping(value = "/topics/{topicid}/courses/{id}" ,method = RequestMethod.GET)
    public Optional<Course> getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @RequestMapping(value = "/topics/{topicId}/courses}", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course,@PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }


    @RequestMapping(value = "/topics/{topicid}/courses/{id}", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course,@PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(value = "/topics/{topicid}/courses/{id}", method = RequestMethod.DELETE)
    public void deleteCourse (@PathVariable String id){

       courseService.deleteCourse(id);
    }



}

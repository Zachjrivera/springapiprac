package creatingmavenspring.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;


    @RequestMapping(value = "/topics",method = RequestMethod.GET)
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();

    }


    @RequestMapping(value = "/topics/{id}" ,method = RequestMethod.GET)
    public Topic gettopic ( @PathVariable String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic){

        topicService.addTopic(topic);
    }


    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){

        topicService.updateTopic(topic,id);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public void deleteTopic (@PathVariable String id){

       topicService.deleteTopic(id);
    }



}

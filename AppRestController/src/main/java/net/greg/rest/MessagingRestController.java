package net.greg.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*
  Add an @Service Annotation !!!

  https://github.com/getstarted-spring/restcontroller
  https://codeburst.io/rest-controller-building-rest-api-638d3ff4fa71
*/
@RestController
@RequestMapping(path = "/messaging")
public class MessagingRestController {

  @GetMapping(path = "/message", params = {"name"})
  public Message getMessage(@RequestParam String name) {

    Message message = new Message();

    message.setText("GET | Hello, " + name);
    return message;
  }

  @PostMapping(path = "/message", params = {"name"})
  public Message setMessage(@RequestParam String name, @RequestBody Message message) {

    message.setText("POST | Hello, " + name);
    return message;
  }
}

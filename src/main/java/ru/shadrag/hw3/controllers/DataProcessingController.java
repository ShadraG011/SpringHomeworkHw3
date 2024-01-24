package ru.shadrag.hw3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.shadrag.hw3.services.DataProcessingService;

@Controller
@RequestMapping("/hw3")
public class DataProcessingController {

    private final DataProcessingService service;

    @Autowired
    public DataProcessingController(DataProcessingService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getUsers() {
        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public ResponseEntity<String> filterUsersByAge(@RequestParam("age") int age) {
        return new ResponseEntity<>(service.filterUsersByAge(age), HttpStatus.OK);
    }

    @RequestMapping(value = "/avg", method = RequestMethod.GET)
    public ResponseEntity<String> getAVGAge() {
        return new ResponseEntity<>(service.getAverageAge(), HttpStatus.OK);
    }

    @RequestMapping(value = "/sortASC", method = RequestMethod.GET)
    public ResponseEntity<String> sortByAgeASK() {
        return new ResponseEntity<>(service.sortUserByAgeASC(), HttpStatus.OK);
    }

    @RequestMapping(value = "/sortDESC", method = RequestMethod.GET)
    public ResponseEntity<String> sortByAgeDESK() {
        return new ResponseEntity<>(service.sortUserByAgeDESC(), HttpStatus.OK);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("email") String email) {
        return new ResponseEntity<>(service.registration(name, age, email), HttpStatus.CREATED);
    }
}

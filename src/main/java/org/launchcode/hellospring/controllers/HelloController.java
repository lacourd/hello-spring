package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HelloController {
//Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

//    handles request of the form /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

//    handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

//Include a new public static method, createMessage, in the HelloController that takes a name as well as a language string. Based on the language string, you’ll display the proper greeting.
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
     public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);

    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        ArrayList<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Darren");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

    public static String createMessage(String name, String language) {
        String greeting = "";
        if (language.equals("english")) {
            greeting = "Hello, ";
        } else if (language.equals("french")) {
            greeting = "Bonjour, ";
        } else if (language.equals("portuguese")) {
            greeting = "Oi, ";
        } else if (language.equals("german")) {
            greeting = "Hallo, ";
        } else if (language.equals("latin")) {
            greeting =  "Salve, ";
        }
        return  greeting + name + "!";
    }
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }
}

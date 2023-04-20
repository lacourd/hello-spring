package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
@ResponseBody
public class HelloController {
//Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")

    public String goodbye(){
        return "Goodbye, Spring!";
    }

//    handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

//    handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

//Include a new public static method, createMessage, in the HelloController that takes a name as well as a language string. Based on the language string, you’ll display the proper greeting.
    @RequestMapping(value = "hello", method = RequestMethod.POST)
     public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);

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
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='language' id='language-select'>" +
                "    <option value=''>--Please choose a language--</option>" +
                "    <option value='english'>English</option>" +
                "    <option value='french'>French</option>" +
                "    <option value='portuguese'>Portuguese</option>" +
                "    <option value='german'>German</option>" +
                "    <option value='latin'>Latin</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}

package com.young.SpringWorld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
// 1. 정적파일 내려주기 -> resources/static 폴더에 path 명과 같은 파일명으로 .html 파일 만들어주기
// 2. template 내려주기 -> mvc 모델로 resources/templates 내의 폴더명이 return문이 되고 controller에서 model에 담아서 값을 넘겨주고 반영하여 template을 내려줌
// 3. api 내려주기 @GetMapping으로 path를 받았다면 @ResponseBody를 붙혀줌

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }

    @GetMapping("hell-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http통신의 body 부분에 return 값을 넣어주겠다.
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello apiHello(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

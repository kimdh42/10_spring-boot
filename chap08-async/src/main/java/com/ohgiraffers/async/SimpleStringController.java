package com.ohgiraffers.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleStringController {

    @GetMapping("/simple-string")
    public String showSimpleString() {
        return "async/simple-string";
    }

    @GetMapping("/xmlhttprequest/simple-string")
    public @ResponseBody String xmlhttprequestTest(@RequestParam String keyword) {

        String responseText = "서버로 전달 된 문자열은 " + keyword + "입니다.";

        return responseText;
    }

    @GetMapping("/jquery/simple-string")
    public @ResponseBody String jqueryTest(@RequestParam String keyword) {

        String responseText = "서버로 전달 된 문자열은 " + keyword + "입니다.";

        return responseText;
    }

    @GetMapping("/fetch/simple-string")
    public @ResponseBody String fetchTest(@RequestParam String keyword) {

        String responseText = "서버로 전달 된 문자열은 " + keyword + "입니다.";

        return responseText;
    }

    @GetMapping("/axios/simple-string")
    public @ResponseBody String axiosTest(@RequestParam String keyword) {

        String responseText = "서버로 전달 된 문자열은 " + keyword + "입니다.";

        return responseText;
    }






}

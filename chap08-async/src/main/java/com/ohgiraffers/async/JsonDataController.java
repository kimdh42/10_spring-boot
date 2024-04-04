package com.ohgiraffers.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class JsonDataController {

    private final List<UserDTO> userList;

    public JsonDataController() {
        userList = new ArrayList<>();
        userList.add(new UserDTO("1", "유관순", 16, "yoo123@ohgiraffers.com", new Date()));
        userList.add(new UserDTO("2", "홍길동", 20, "hong123@ohgiraffers.com", new Date()));
        userList.add(new UserDTO("3", "신사임당", 30, "shin123@ohgiraffers.com", new Date()));
    }

    @GetMapping("/json-data")
    public String showJsonData() {
        return "async/json-data";
    }

    /* @RequestBody : 요청 바디에 담긴 데이터를 java 객체에 매핑할 때 사용하는 어노테이션
    spring boot web 모듈에는 Jackson-databind 라이브러리가 기본 포함 되어 JSON => Java Object parsing이 자동 처리 된다.
    * 1. String : "{"nickname":"별명","age":"20","email":"hello@ohgiraffers.com","registDate":"2024-03-14"}"
    * 2. Map : {nickname=별명, age=20, email=hello@ohgiraffers.com, registDate=2024-03-14}
    * 3. UserDTO : UserDTO{id='null', nickname='별명', age=20, email='hello@ohgiraffers.com', registDate=Thu Mar 14 09:00:00 KST 2024}
    * 4. List<UserDTO> :
    [UserDTO{id='null', nickname='1234', age=20, email='hong@gmail.com', registDate=Thu Mar 14 09:00:00 KST 2024},
    UserDTO{id='null', nickname='1234', age=20, email='hong@gmail.com', registDate=Thu Mar 14 09:00:00 KST 2024},
    UserDTO{id='null', nickname='1234', age=20, email='hong@gmail.com', registDate=Thu Mar 14 09:00:00 KST 2024}]
    * */
    @PostMapping("/jquery/json")
    public @ResponseBody String jqueryJsonTest(@RequestBody List<UserDTO> requestBody) {

        System.out.println("requestBody : " + requestBody);

        return "success";
    }

    @PostMapping("/fetch/json")
    public @ResponseBody String fetchJsonTest(@RequestBody List<UserDTO> requestBody) {

        System.out.println("requestBody : " + requestBody);

        return "success";
    }

    /* jackson databind 라이브러리 의존성이 있을 경우 응답 시 자바 객체를 JSON 형태로 자동 변환해준다. */
    @GetMapping("/jquery/json")
    public @ResponseBody List<UserDTO> jqueryJsonTest() {

        return userList;
    }

    @GetMapping("/fetch/json")
    public @ResponseBody List<UserDTO> fetchJsonTest() {

        return userList;
    }






}

package com.ohgiraffers.thymeleaf.controller;

import com.ohgiraffers.thymeleaf.model.dto.MemberDTO;
import com.ohgiraffers.thymeleaf.model.dto.SelectCriteria;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("lecture")
public class LectureController {

    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv) {

        mv.addObject("member", new MemberDTO("판다", 20, '여',"서울시 종로구"));

        mv.addObject("hello", "<h3>hello Thymeleaf</h3>");

        mv.setViewName("/lecture/expression");

        return mv;
    }

    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv) {

        mv.addObject("num", 328);
        mv.addObject("str", "바나나");

        mv.setViewName("/lecture/conditional");

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("판다", 20, '여', "서울시 종로구 8강"));
        memberList.add(new MemberDTO("다람쥐", 900, '무', "서울시 종로구 10강"));
        memberList.add(new MemberDTO("양", 300, '여', "하이미디어 15층"));
        memberList.add(new MemberDTO("뱀", 100, '여', "서울시 종로구 1강"));

        mv.addObject("memberList", memberList);

        return mv;
    }

    @GetMapping("etc")
    public ModelAndView etc(ModelAndView mv) {

        SelectCriteria selectCriteria =
                new SelectCriteria(1, 10, 7);
        mv.addObject(selectCriteria);

        mv.setViewName("/lecture/etc");

        return mv;
    }

    @GetMapping("fragment")
    public ModelAndView fragment(ModelAndView mv) {

        mv.addObject("test1", "value1");
        mv.addObject("test2", "value2");

        mv.setViewName("/lecture/fragment");

        return mv;
    }
}

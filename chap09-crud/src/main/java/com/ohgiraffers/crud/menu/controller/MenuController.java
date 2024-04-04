package com.ohgiraffers.crud.menu.controller;

import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.crud.menu.model.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/menu")
public class MenuController {



    /* logging을 사용하기 위해서는 Logger 객체 생성을 해야한다. */
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    /* menuService에 의존성 주입*/
    private final MenuService menuService;

    private MessageSource messageSource;

    /* @Autowired 생략되어 있음 */
    public MenuController(MenuService menuService, MessageSource messageSource) {
        this.menuService = menuService;
        this.messageSource = messageSource;
    }

    @GetMapping("/list")
    public String findMenuList(Model model) {

        List<MenuDTO> menuList = menuService.findAllMenu();

        model.addAttribute("menuList", menuList);

        return "menu/list";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @GetMapping("/category")
    public @ResponseBody List<CategoryDTO> findCategoryList() {

        return menuService.findCategoryList();
    }

    @PostMapping("/regist")
    public String registMenu(@ModelAttribute MenuDTO menu, RedirectAttributes rttr, Locale locale) {

        /* 로그 레벨 테스트 */
        logger.trace("menu : {}", menu);
        logger.debug("menu : {}", menu);
        logger.info("menu : {}", menu);
        logger.warn("menu : {}", menu);
        logger.error("menu : {}", menu);


        menuService.registMenu(menu);

        rttr.addFlashAttribute("successMessage", messageSource.getMessage("registMenu", null, locale));

        return "redirect:/menu/list";
    }

}

package samt.loraterra.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import samt.loraterra.service.MainPageUserService;


@RequestMapping("/")
@Controller
public class MainPageController {

    private final MainPageUserService mainPageUserService;

    @Autowired
    public MainPageController(MainPageUserService mainPageUserService) {
        this.mainPageUserService = mainPageUserService;
    }

    @GetMapping
    public String index(Model model) {
       model.addAttribute("users", mainPageUserService.getUsers());
       return "mainPage";
    }


}

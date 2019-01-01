package com.somecompany.controller;

import com.somecompany.entity.ComputerComponent;
import com.somecompany.service.ComputerComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ComputerComponentController {

    public static final int LIMIT_RESULTS_ON_PAGE = 10;

    @Autowired
    private ComputerComponentService computerComponentService;

    @RequestMapping("/")
    public String getListComponentsPage(@ModelAttribute("page") String strPage,
                                        @ModelAttribute("necessary") String necessary,
                                        @ModelAttribute("search") String search,
                                        Model model) {
        if (search != null) {
            int page = 1;
            if (strPage != null && !strPage.isEmpty()) {
                page = Integer.parseInt(strPage);
            }

            String strQuery = "from ComputerComponent where name like '%" + search + "%'";

            if (necessary == null || necessary.isEmpty() || necessary.equals("0")) {
                strQuery += "";
            } else if (necessary.equals("1")) {
                strQuery += " and necessary = 1";
            } else if (necessary.equals("2")) {
                strQuery += " and necessary = 0";
            }

            List<ComputerComponent> components = computerComponentService.getComponents(strQuery);

            int pages = components.size() / LIMIT_RESULTS_ON_PAGE;

            pages = components.size() % LIMIT_RESULTS_ON_PAGE == 0 ? pages : pages + 1;

            List<ComputerComponent> componentsPaging = computerComponentService.getComponents(strQuery, page);

            strQuery = "from ComputerComponent";
            List<ComputerComponent> allComponents = computerComponentService.getComponents(strQuery);

            int numberComputers = Integer.MAX_VALUE;

            if (!allComponents.isEmpty()) {

                for (ComputerComponent component : allComponents) {
                    if (component.isNecessary() && component.getNumberComponent() < numberComputers) {
                        numberComputers = component.getNumberComponent();
                    }
                }
            } else {
                numberComputers = 0;
            }

            model.addAttribute("components", componentsPaging);
            model.addAttribute("pages", pages);
            model.addAttribute("numberComputers", numberComputers);
            model.addAttribute("necessary", necessary);
            model.addAttribute("search", search);
        }

        return "allComponents";
    }

    @GetMapping("/add")
    public String getAddComponentPage(Model model) {
        ComputerComponent component = new ComputerComponent();
        model.addAttribute("component", component);

        return "addComponent";
    }

    @PostMapping("save")
    public String saveComponent(@ModelAttribute("component") ComputerComponent component) {
        if(component.getName() != null && !component.getName().isEmpty()) {
            computerComponentService.saveComponent(component);
        }

        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateComponent(@RequestParam("componentId") int id, Model model) {
        ComputerComponent component = computerComponentService.getComponent(id);
        model.addAttribute("component", component);

        return "addComponent";
    }

    @GetMapping("/delete")
    public String deleteComponent(@RequestParam("componentId") int id) {
        computerComponentService.deleteComponent(id);

        return "redirect:/";
    }
}

package org.example.ex_06.controller;

import org.example.ex_06.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PromotionController {
    private final DishService dishService;

    public PromotionController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/promotions")
    public String promotionList(ModelMap modelMap) {
        modelMap.addAttribute("dishes", dishService.getPromotionDishes());
        return "promotion-list";
    }
}


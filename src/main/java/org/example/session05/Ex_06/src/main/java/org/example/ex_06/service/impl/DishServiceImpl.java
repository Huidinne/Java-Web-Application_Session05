package org.example.ex_06.service.impl;

import org.example.ex_06.model.Dish;
import org.example.ex_06.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Override
    public List<Dish> getPromotionDishes() {
        return List.of(
                new Dish(1L, "Beef Steak", 350000, 15),
                new Dish(2L, "Salmon Teriyaki", 280000, 25),
                new Dish(3L, "Chicken Caesar Salad", 160000, 10),
                new Dish(4L, "Seafood Pizza", 220000, 30)
        );
    }
}


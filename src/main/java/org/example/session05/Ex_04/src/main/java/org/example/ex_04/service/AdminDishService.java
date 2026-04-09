package org.example.ex_04.service;

import org.example.ex_04.common.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminDishService {

    private final List<Dish> dishes = new ArrayList<>();

    public AdminDishService() {
        dishes.add(new Dish(1L, "Phở bò", 50000, true));
        dishes.add(new Dish(2L, "Bún chả", 45000, false));
        dishes.add(new Dish(3L, "Cơm rang", 40000, true));
    }

    public List<Dish> getAllDishes() {
        return new ArrayList<>(dishes);
    }

    public Optional<Dish> findById(Long id) {
        return dishes.stream()
                .filter(dish -> dish.getId().equals(id))
                .findFirst();
    }

    public boolean updateDish(Long id, Dish updatedDish) {
        Optional<Dish> existingDishOpt = findById(id);
        if (existingDishOpt.isEmpty()) {
            return false;
        }

        Dish existingDish = existingDishOpt.get();
        existingDish.setName(updatedDish.getName());
        existingDish.setPrice(updatedDish.getPrice());
        existingDish.setAvailable(updatedDish.isAvailable());
        return true;
    }
}


package org.example.ex_06.service;

import org.example.ex_06.service.impl.DishServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DishServiceImplTest {

    @Test
    void getPromotionDishes_shouldReturnSampleDataWithAtLeastOneHotDeal() {
        DishService dishService = new DishServiceImpl();

        var dishes = dishService.getPromotionDishes();

        assertFalse(dishes.isEmpty(), "Promotion list should not be empty in mock data");
        assertTrue(
                dishes.stream().anyMatch(dish -> dish.getDiscountPercent() > 20),
                "There should be at least one HOT DEAL dish (>20%)"
        );
    }
}


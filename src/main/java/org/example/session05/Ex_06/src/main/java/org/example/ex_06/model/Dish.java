package org.example.ex_06.model;

public class Dish {
    private final Long id;
    private final String name;
    private final double originalPrice;
    private final int discountPercent;

    public Dish(Long id, String name, double originalPrice, int discountPercent) {
        this.id = id;
        this.name = name;
        this.originalPrice = originalPrice;
        this.discountPercent = discountPercent;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public double getDiscountedPrice() {
        return originalPrice * (100 - discountPercent) / 100;
    }
}


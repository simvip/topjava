package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * GKislin
 * 11.01.2015.
 */
public class Meal {
    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private int id;

    public Meal(LocalDateTime dateTime, String description, int calories,int id) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.id = id;
    }

    public Meal(MealWithExceed mealWithExceed,int id) {
        this.dateTime = mealWithExceed.getDateTime();
        this.description = mealWithExceed.getDescription();
        this.calories = mealWithExceed.getCalories();
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }
}

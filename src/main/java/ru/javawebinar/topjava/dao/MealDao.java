package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

import java.util.List;

/**
 * Created by Admin on 29.03.2017.
 */
public interface MealDao {
    List<Meal> getlist();
    void create(MealWithExceed meal);
    void update(MealWithExceed meal);

    void delete(int id);
}

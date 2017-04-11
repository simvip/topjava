package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Created by Admin on 29.03.2017.
 */
public class MealDaoImplInMemory implements MealDao {

    volatile static int COUNT=0;

    static ConcurrentMap<Integer,Meal> meals;

    static{
        meals = new ConcurrentHashMap();
        meals.put(1,new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500,COUNT++));
        meals.put(2,new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000,COUNT++));
        meals.put(3,new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500,COUNT++));
        meals.put(4,new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000,COUNT++));
        meals.put(5,new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500,COUNT++));
        meals.put(6,new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510,COUNT++));
    }

    @Override
    public List<Meal> getlist() {
        return meals.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
    }

    @Override
    public void create(MealWithExceed mealWithExceed) {
        meals.put(mealWithExceed.getId(),new Meal(mealWithExceed,COUNT++));
    }

    @Override
    public void update(MealWithExceed mealWithExceed) {
        if (mealWithExceed.getId()==0||!meals.containsKey(mealWithExceed.getId())){
            return;
        }
        meals.put(mealWithExceed.getId(),new Meal(mealWithExceed,mealWithExceed.getId()));
    }

    @Override
    public void delete(int id) {
        if (meals.containsKey(id)){
            meals.remove(id);
        }
    }
}

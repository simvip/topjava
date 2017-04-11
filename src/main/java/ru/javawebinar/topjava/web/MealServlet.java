package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.MealDaoImplInMemory;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Admin on 29.03.2017.
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);
    private MealDao mealDao = new MealDaoImplInMemory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug("do get meal");
        List<MealWithExceed> filteredWithExceeded = MealsUtil.getFilteredWithExceeded(mealDao.getlist(), MealsUtil.STARTDATE, MealsUtil.ENDDATE, 1000);

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("meals",filteredWithExceeded);
        req.getRequestDispatcher("meals.jsp").forward(req, resp);

        //resp.sendRedirect("meals.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

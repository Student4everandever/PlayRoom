package ua.training.task2.controller.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        ServletContext context = event.getSession().getServletContext();
        event.getSession().setAttribute("locale", context.getInitParameter("locale"));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
    }
}

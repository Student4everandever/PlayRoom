package ua.training.task2.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LanguageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getHeader("referer");
        //url = url.replaceAll("/?locale/*.", "");
        request.getSession().setAttribute("locale", request.getParameter("locale"));
        return "redirect:" + url;
    }
}

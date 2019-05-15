package ua.training.task2.controller.commands;

import ua.training.task2.model.entity.PlayRoom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class RoomsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        ArrayList<PlayRoom> rooms = (ArrayList<PlayRoom>) request.getSession().getServletContext()
                .getAttribute("rooms");
        String message;
        String locale = request.getSession().getAttribute("locale").toString();
        ResourceBundle bundle = ResourceBundle.getBundle("lang", new Locale(locale));

        if(rooms.size() == 0) {
            message = bundle.getString("no_rooms_created");
        } else {
            message = "";
        }
        request.getSession().getServletContext().setAttribute("message", message);
        return "/roomsList.jsp";
    }
}

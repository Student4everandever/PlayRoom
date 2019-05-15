package ua.training.task2.controller.commands;

import ua.training.task2.model.entity.PlayRoom;
import ua.training.task2.model.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String loc = request.getSession().getAttribute("locale").toString();
        Locale locale = new Locale(loc);
        ResourceBundle bundle = ResourceBundle.getBundle("lang", locale);

        ArrayList<PlayRoom> rooms = (ArrayList<PlayRoom>) request.getSession().getServletContext()
                .getAttribute("rooms");

        Creator creator = new Creator();
        PlayRoom createdRoom = creator.create(rooms);
        createdRoom.setCreated(new SimpleDateFormat(bundle.getString("date")).format(new Date()));
        createdRoom.setCreatedUa(new SimpleDateFormat(bundle.getString("date.ua")).format(new Date()));

        rooms.add(createdRoom);
        request.getSession().getServletContext().setAttribute("rooms", rooms);
        return "/playRooms.jsp";
    }
}

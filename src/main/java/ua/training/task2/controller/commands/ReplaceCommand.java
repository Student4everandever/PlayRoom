package ua.training.task2.controller.commands;

import ua.training.task2.model.entity.PlayRoom;
import ua.training.task2.model.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReplaceCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<PlayRoom> allRooms = (ArrayList<PlayRoom>) request.getSession().getServletContext()
                .getAttribute("rooms");
        String loc = request.getSession().getAttribute("locale").toString();
        Locale locale = new Locale(loc);
        ResourceBundle bundle = ResourceBundle.getBundle("lang", locale);
        String message = "";
        PlayRoom changedRoom;
        String roomName = Optional.ofNullable(request.getParameter("Roomname")).orElse("");

        String[] toysToRemove = new String[6];
        toysToRemove[0] = Optional.ofNullable(request.getParameter("Doll")).orElse("");
        toysToRemove[1] = Optional.ofNullable(request.getParameter("Pencils")).orElse("");
        toysToRemove[2] = Optional.ofNullable(request.getParameter("Puzzle")).orElse("");
        toysToRemove[3] = Optional.ofNullable(request.getParameter("Pyramid")).orElse("");
        toysToRemove[4] = Optional.ofNullable(request.getParameter("Top")).orElse("");
        toysToRemove[5] = Optional.ofNullable(request.getParameter("Toycar")).orElse("");

        boolean noToysToChange = Arrays.stream(toysToRemove).allMatch(x -> x.equals(""));
        if (roomName.equals("") && noToysToChange) {
            request.getSession().getServletContext().setAttribute("message", message);
            return "/replacePage.jsp";
        }
        if (noToysToChange) {
            message = bundle.getString("choose_the_toys");
            request.getSession().getServletContext().setAttribute("message", message);
            return "/replacePage.jsp";
        }
        if (roomName.equals("")) {
            message = bundle.getString("choose_the_room_to_update");
            request.getSession().getServletContext().setAttribute("message", message);
            return "/replacePage.jsp";
        }

        int roomNumberToUpdate = Integer.parseInt(roomName) - 1;
        if (roomNumberToUpdate < 0 || roomNumberToUpdate > allRooms.size() - 1) {
            message = bundle.getString("no_room_number") + roomName;
            request.getSession().getServletContext().setAttribute("message", message);
            return "/replacePage.jsp";
        }

        RoomChanger roomChanger = new RoomChanger();
        PlayRoom roomToUpdate = allRooms.get(roomNumberToUpdate);
        changedRoom = roomChanger.replaceToys(toysToRemove, roomToUpdate);
        changedRoom.setModified(new SimpleDateFormat(bundle.getString("date")).format(new Date()));
        changedRoom.setModifiedUa(new SimpleDateFormat(bundle.getString("date.ua")).format(new Date()));


        allRooms.set(roomNumberToUpdate, changedRoom);
        message = bundle.getString("the_room_number") + (roomNumberToUpdate + 1) + bundle.getString("was_updated");
        request.getSession().getServletContext().setAttribute("message", message);
        request.getSession().getServletContext().setAttribute("rooms", allRooms);
        return "/replacePage.jsp";
    }
}

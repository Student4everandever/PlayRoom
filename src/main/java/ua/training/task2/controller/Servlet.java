package ua.training.task2.controller;

import ua.training.task2.controller.commands.*;
import ua.training.task2.model.entity.PlayRoom;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig){

        servletConfig.getServletContext().setAttribute("rooms", new ArrayList<PlayRoom>());

        commands.put("create", new CreateCommand());
        commands.put("replace", new ReplaceCommand());
        commands.put("roomList", new RoomsCommand());
        commands.put("language", new LanguageCommand());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        //System.out.println(path);
        path = path.replaceAll(".*/room/", "");
        //System.out.println(path);
        Command command = commands.getOrDefault(path ,
                (req, resp)->"/index.jsp");
        String page = command.execute(request, response);
        if(page.contains("redirect")){
            response.sendRedirect(page.replace("redirect:", ""));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
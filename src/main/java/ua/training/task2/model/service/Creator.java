package ua.training.task2.model.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.training.task2.model.entity.PlayRoom;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Creator {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
    );

    public PlayRoom create (ArrayList<PlayRoom> rooms) {
        PlayRoom playRoom = context.getBean("playRoom", PlayRoom.class);
        playRoom.setName(playRoom.getName() + " " + (rooms.size() + 1));

        return playRoom;
    }
}

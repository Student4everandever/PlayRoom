package ua.training.task2.model.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.training.task2.model.entity.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class RoomChanger {

    public RoomChanger() {
    }

    public PlayRoom replaceToys(String[] toysToRemove, PlayRoom playRoomToUpdate) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        List<Toy> toysToUpdate = new ArrayList<>();

        toysToUpdate.add(context.getBean("doll", Doll.class));
        toysToUpdate.add(context.getBean("pencils", Pencils.class));
        toysToUpdate.add(context.getBean("puzzle", Puzzle.class));
        toysToUpdate.add(context.getBean("pyramid", Pyramid.class));
        toysToUpdate.add(context.getBean("top", Top.class));
        toysToUpdate.add(context.getBean("toycar", ToyCar.class));

        List<Toy> listWithBrokenToys = playRoomToUpdate.getToyList();
        //TODO rewrite with streams

/*        Arrays.stream(toysToRemove)
                .filter(x-> !x.equals(""))
                .map(x->indexOf(toysToRemove, x))
                .forEach(x->listWithBrokenToys.set(x, toysToUpdate.get(x)));
*/

        for (int i = 0; i < toysToRemove.length; i++) {
            if (!toysToRemove[i].equals("")) {
                listWithBrokenToys.set(i, toysToUpdate.get(i));
            }
        }

        return playRoomToUpdate;
    }
}
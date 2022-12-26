package ru.viktoria.cw4;

import ru.viktoria.cw4.entity.Climber;
import ru.viktoria.cw4.entity.Group;
import ru.viktoria.cw4.entity.Mountain;

import java.util.GregorianCalendar;

public class Application {
    public static void main(String[] args) {
        Mountain mountain1 = new Mountain("Арарат", "Турция", 5137);
        Mountain mountain2 = new Mountain("Монблан", "Франция", 4810);
        Mountain mountain3 = new Mountain("Эверест", "Непал", 8848);
        mountain1.save();
        mountain2.save();
        mountain3.save();
        Climber climber1 = new Climber("Мария", "Карла Маркса 134");
        Climber climber2 = new Climber("Юрий", "Чаренца 1");
        Climber climber3 = new Climber("Олег", "Геворга Джаукяна 54");
        Climber climber4 = new Climber("Михаил", "Мира 32");
        Climber climber5 = new Climber("Святослав", "Ленина 134");
        Climber climber6 = new Climber("Мария", "Типанова 14");
        climber1.save();
        climber2.save();
        climber3.save();
        climber4.save();
        climber5.save();
        climber6.save();
        Group group1 = new Group(2,
                new GregorianCalendar(2023, 11, 7, 18, 30),
                mountain1);
        Group group2 = new Group(3,
                new GregorianCalendar(2023, 4, 4, 9, 00),
                mountain2);
        Group group3 = new Group(2,
                new GregorianCalendar(2023, 9, 23, 13, 30),
                mountain3);
        group1.save();
        group2.save();
        group3.save();
        group1.addClimber(climber1);
        group2.addClimber(climber2);
        group3.addClimber(climber3);
        group1.addClimber(climber4);
        group2.addClimber(climber5);
        group3.addClimber(climber6);
        group1.update();
        group2.update();
        group3.update();
        mountain1.update();
        mountain2.update();
        mountain3.update();
        climber1.update();
        climber2.update();
        climber3.update();
        climber4.update();
        climber5.update();
        climber6.update();
        group2.removeClimber(climber2);
        group1.removeClimber(climber1);
        group2.update();
        group1.update();
        climber1.update();
        climber2.update();
        group1.addClimber(climber1);
        group1.update();
    }
}

package ru.viktoria.cw4;

import ru.viktoria.cw4.db.GeneralDao;
import ru.viktoria.cw4.entity.Climber;
import ru.viktoria.cw4.entity.Group;
import ru.viktoria.cw4.entity.Mountain;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Application {
    public static void main(String[] args) {
        Mountain mountain1 = new Mountain("Арарат", "Турция", 5137);
        Mountain mountain2 = new Mountain("Монблан", "Франция", 4810);
        Mountain mountain3 = new Mountain("Эверест", "Непал", 8848);
        GeneralDao<Mountain, Integer> mountainDao = new GeneralDao<>();
        mountainDao.save(mountain1);
        mountainDao.save(mountain2);
        mountainDao.save(mountain3);
        Climber climber1 = new Climber("Мария", "Карла Маркса 134");
        Climber climber2 = new Climber("Юрий", "Чаренца 1");
        Climber climber3 = new Climber("Олег", "Геворга Джаукяна 54");
        Climber climber4 = new Climber("Михаил", "Мира 32");
        Climber climber5 = new Climber("Святослав", "Ленина 134");
        Climber climber6 = new Climber("Мария", "Типанова 14");
        GeneralDao<Climber, Integer> climberDao = new GeneralDao<>();
        climberDao.save(climber1);
        climberDao.save(climber2);
        climberDao.save(climber3);
        climberDao.save(climber4);
        climberDao.save(climber5);
        climberDao.save(climber6);
        Group group1 = new Group(2,
                new GregorianCalendar(2023, Calendar.NOVEMBER, 7, 18, 30),
                mountain1);
        Group group2 = new Group(3,
                new GregorianCalendar(2023, Calendar.APRIL, 4, 9, 0),
                mountain2);
        Group group3 = new Group(2,
                new GregorianCalendar(2023, Calendar.SEPTEMBER, 23, 13, 30),
                mountain3);
        GeneralDao<Group, Integer> groupDao = new GeneralDao<>();
        groupDao.save(group1);
        groupDao.save(group2);
        groupDao.save(group3);
        group1.addClimber(climber1);
        group2.addClimber(climber2);
        group3.addClimber(climber3);
        group1.addClimber(climber4);
        group2.addClimber(climber5);
        group3.addClimber(climber6);
        groupDao.update(group1);
        groupDao.update(group2);
        groupDao.update(group3);
        mountainDao.update(mountain1);
        mountainDao.update(mountain2);
        mountainDao.update(mountain3);
        climberDao.update(climber1);
        climberDao.update(climber2);
        climberDao.update(climber3);
        climberDao.update(climber4);
        climberDao.update(climber5);
        climberDao.update(climber6);
        group2.removeClimber(climber2);
        group1.removeClimber(climber1);
        groupDao.update(group2);
        groupDao.update(group1);
        climberDao.update(climber1);
        climberDao.update(climber2);
        group1.addClimber(climber1);
        groupDao.update(group1);
        climberDao.update(climber1);
    }
}

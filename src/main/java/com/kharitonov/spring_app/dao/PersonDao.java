package com.kharitonov.spring_app.dao;

import com.kharitonov.spring_app.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int count = 0;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++count, "ivan ivanov"));
        people.add(new Person(++count, "petr petrov"));
        people.add(new Person(++count, "alex alexeev"));
        people.add(new Person(++count, "mike matusov"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(p->p.getId() == id).findAny().orElse(null);
    }
}

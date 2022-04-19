package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> name = Arrays.asList("Dima", "Sasha", "Nastya", "Artem", "Maxim");
        List<String> lastName = Arrays.asList("Lunyakov", "Kholodkov", "Morzhakova", "Inozemtsev", "Spiridonov");
        Collection<Person> people = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            people.add(new Person(name.get(new Random().nextInt(name.size())),
                    lastName.get(new Random().nextInt(lastName.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]));
        }
        System.out.println("Весь список:");
        people.stream()
                .forEach(System.out::println);
        System.out.println("Совершеннолетние:");
        people.stream()
                .filter(person -> person.getAge() >= 18)
                .forEach(System.out::println);
        System.out.println("Призывники:");
        people.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27 && person.getSex().equals(Sex.MAN))
                .forEach(person -> System.out.println(person.getName() + " " + person.getFamily()));
        System.out.println("Работоспособные люди:");
        people.stream()
                .filter(person -> (person.getSex().equals(Sex.WOMAN) && person.getAge() >= 18 && person.getAge() < 60) || (person.getSex().equals(Sex.MAN) && person.getAge() >= 18 && person.getAge() < 65))
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .forEach(person -> System.out.println(person.getName() + " " + person.getFamily()));
    }
}

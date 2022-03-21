package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        //System.out.println("Количество несовершеннолетних:");
        long count = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.print(count + "\"Количество несовершеннолетних:\" ");


        List<String> col = persons.stream()
                .filter(m -> m.getAge() >= 18 || m.getAge() >= 27)
                .filter(m -> m.getSex() == Sex.MAN)
                .map(Person::getFamily).collect(Collectors.toList());

        System.out.println(col);



            List<Person> list = persons.stream()
                    .filter(v -> v.getAge() < 18 && v.getSex() == Sex.MAN && v.getAge() <= 65)
                    .filter(v -> v.getAge() >= 18 &&  v.getSex() == Sex.WOMAN && v.getAge() <= 60)
                    .sorted(Comparator.comparing(Person::getEducation)).collect(Collectors.toList());

             list.forEach(System.out::println);

        }
    }
//}
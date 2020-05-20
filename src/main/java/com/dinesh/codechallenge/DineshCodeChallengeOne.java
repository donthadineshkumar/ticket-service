package com.dinesh.codechallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class DineshCodeChallengeOne {

    /*
    *    Person class has 4 attributes namely Age , Gender, Slary & Location
    *    Create Sufficient Person Data to achieve following requirements
    *    1. Average Salary of Persons who are
    *       - Age > 25
    *       - Salary > 2000
    *       - Location belong to Hyderabad
    *       - Gender is Female
    *
    *    2. Segregate Persons based on their locations
    *
    *   Note : Use only Java 8 features like treams , Method refrence , Optionals , Predicate etc
     */
    static class Person{

        private Integer age;
        private String gender;
        private Integer salary;
        private String location;

        public Person(Integer age, String gender, Integer salary, String location) {
            this.age = age;
            this.gender = gender;
            this.salary = salary;
            this.location = location;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }


    public static void main(String[] args) {
        Person p1 = new Person(25, "MALE", 3000, "Hyderabad");
        Person p2 = new Person(20, "FEMALE", 3000, "Banglore");
        Person p3 = new Person(21, "MALE", 3500, "Hyderabad");
        Person p4 = new Person(30, "MALE", 3000, "Banglore");
        Person p5 = new Person(25, "FEMALE", 1200, "Mumbai");
        Person p6 = new Person(20, "FEMALE", 3000, "Banglore");
        Person p7 = new Person(30, "FEMALE", 2500, "Hyderabad");
        Person p8 = new Person(30, "MALE", 3000, "Mumbai");

        List<Person> personsList = new ArrayList<>();
        personsList.add(p1);
        personsList.add(p2);
        personsList.add(p3);
        personsList.add(p4);personsList.add(p5);personsList.add(p6);personsList.add(p7);
        personsList.add(p8);

        //persons with age>25
        OptionalDouble average_sakary_persons = personsList.stream().filter(DineshCodeChallengeOne::isAgeGreaterThan25)
                            .filter((person) -> person.getSalary()>2000)
                            .filter((person) -> person.getLocation()
                                    .equalsIgnoreCase("Hyderabad"))
                            .filter((person) ->
                                    person.getGender().equalsIgnoreCase("female"))
                            .mapToDouble(Person::getSalary).average();

        System.out.println(average_sakary_persons);

        personsList.stream().collect(Collectors.groupingBy(person -> person.getLocation()))
                .entrySet().forEach(System.out::println);

}
    public static boolean isAgeGreaterThan25(Person person){
        return person.getAge()>25;
    }





}

package com.peksoft;

import com.peksoft.entity.Employee;
import com.peksoft.util.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        Hibernate.getSession();
//        Employee employee = new Employee("Aza",20);
//        create(employee);
//        Employee employee1 = new Employee("Aza",19);
//        create(employee1);
//        Employee employee2 = new Employee("Aza",25);
//        create(employee2);
//        Employee employee3 = new Employee("Aza",25);
//        create(employee3);
//        Employee employee4 = new Employee("Aza",22);
//        create(employee4);
//        Employee employee5 = new Employee("Melis",20);
//        create(employee5);
//        Employee employee6 = new Employee("Sadyr",12);
//        create(employee6);
//        Employee employee7 = new Employee("Joomart",34);
//        create(employee7);
//        Employee employee8 = new Employee("Aza",20);
//        create(employee8);
//        Employee employee9 = new Employee("Aza",20);
//        create(employee9);


//        deleteByName("Aza");
//        update("Aza",18);
        getByName("Aza",20);


    }

    public static int create(Employee employee) {
        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully" + employee);
        return employee.getId();
    }





    public static void deleteByName(String name) {
        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Employee WHERE name =:name")
                .setParameter("name", name);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted Person is " + name);
    }

    public static void update(String name, int age) {
        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("UPDATE Employee set age=:age WHERE name =:name")
                .setParameter("name", name).setParameter("age", age);
        System.out.println("SuccessFully age changed " + name + " " + age);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
    public static List<Employee> getByName(String name, int age){
        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        List<Employee> personList = session.createQuery("FROM Employee  WHERE name =: name and age >: age").
                setParameter("name",name).setParameter("age",age).getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("found"+ personList.toString());
        return personList;
    }





}






package com.aldi.hibernate;

import java.util.Date;

import com.aldi.hibernate.entity.Student;
import com.aldi.hibernate.utils.DateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("creating new student object...");

            String theDateOfBirthStr = "22/05/1999";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);

            Student student = new Student("Piero", "Ashady", "piero@gmail.com", theDateOfBirth);

            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}

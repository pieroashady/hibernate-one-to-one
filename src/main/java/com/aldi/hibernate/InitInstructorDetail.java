package com.aldi.hibernate;

import com.aldi.hibernate.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class InitInstructorDetail {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory factory = configuration.addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory(builder.build());
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        try {

            InstructorDetail instructorDetail = new InstructorDetail();
            instructorDetail.setYoutubeChannel("aldipiero");
            instructorDetail.setHobby("futsal");
            session.save(instructorDetail);

            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            session.close();
        }
    }
}

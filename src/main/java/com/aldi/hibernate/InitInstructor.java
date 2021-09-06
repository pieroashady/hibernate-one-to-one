package com.aldi.hibernate;

import com.aldi.hibernate.entity.Instructor;
import com.aldi.hibernate.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class InitInstructor {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory factory = configuration.addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class).buildSessionFactory(builder.build());
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        try {

            Instructor instructor = new Instructor();
            instructor.setFirstName("Piero");
            instructor.setLastName("Ashady");
            instructor.setEmail("aldi@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("aldigaming", "futsal");
            instructor.setInstructorDetail(instructorDetail);
            session.save(instructor);

            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            session.close();
        }
    }
}

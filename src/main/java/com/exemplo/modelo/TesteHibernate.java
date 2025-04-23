package com.exemplo.modelo;

//import com.exemplo.modelo.Pessoa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TesteHibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Pessoa p = new Pessoa();
        p.setNome("Pedro");
        p.setIdade(24);

        session.beginTransaction();
        session.persist(p);
        session.getTransaction().commit();

        session.close();
        factory.close();

        System.out.println("Pessoa salva com sucesso!");
    }
}



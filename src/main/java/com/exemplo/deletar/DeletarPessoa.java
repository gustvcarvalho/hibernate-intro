package com.exemplo.deletar;
	
import com.exemplo.modelo.Pessoa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletarPessoa {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();

        Pessoa p = session.get(Pessoa.class, 1);

        if (p != null) {
            session.remove(p);
            System.out.println("Pessoa com ID 1 apagada com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada!");
        }
        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}
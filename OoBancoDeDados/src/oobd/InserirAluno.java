package oobd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class InserirAluno {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db/p2.odb");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Criação e persistência de vários alunos
            Aluno aluno1 = new Aluno(null, "João Silva", "joao@email.com", new Date());
            Aluno aluno2 = new Aluno(null, "Maria Oliveira", "maria@email.com", new Date());
            Aluno aluno3 = new Aluno(null, "Carlos Santos", "carlos@email.com", new Date());

            em.persist(aluno1);
            em.persist(aluno2);
            em.persist(aluno3);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao persistir dados: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}


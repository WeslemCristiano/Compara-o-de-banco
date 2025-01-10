package oobd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ConsultarAluno {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db/p2.odb");
        EntityManager em = emf.createEntityManager();

        try {
            List<Aluno> alunos = em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();

            for (Aluno aluno : alunos) {
                System.out.println("=== Dados do Aluno ===");
                System.out.println("ID: " + aluno.getId());
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Email: " + aluno.getEmail());
                System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}

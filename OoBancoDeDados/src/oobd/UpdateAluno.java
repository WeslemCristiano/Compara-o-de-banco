package oobd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateAluno {
	
	public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            // Conexão com o banco de dados ObjectDB
            emf = Persistence.createEntityManagerFactory("db/p2.odb");
            em = emf.createEntityManager();
            
            // Busca um aluno com ID 1 e atualiza
            Aluno aluno = em.find(Aluno.class, 1L); // Busca o aluno com ID 1
            if (aluno != null) {
                em.getTransaction().begin();
                aluno.setEmail("novoemail@email.com"); // Atualiza o e-mail
                em.merge(aluno); // Salva as alterações
                em.getTransaction().commit();
            }

            // Atualiza registros baseados com codição
            
            em.getTransaction().begin();
            em.createQuery("UPDATE Aluno a SET a.email = :email WHERE a.nome = :nome")
              .setParameter("email", "maria.novo@email.com")
              .setParameter("nome", "Maria Oliveira")
              .executeUpdate();
            em.getTransaction().commit();

            
        } finally {
            // Fecha os recursos do EntityManager e EntityManagerFactory
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }

}

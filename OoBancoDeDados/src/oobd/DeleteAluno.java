package oobd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteAluno {
	
	   public static void main(String[] args) {
	        EntityManagerFactory emf = null;
	        EntityManager em = null;

	        try {
	            // Conexão com o banco de dados ObjectDB
	            emf = Persistence.createEntityManagerFactory("db/p2.odb");
	            em = emf.createEntityManager();
	            
	            // Busca um aluno com ID 1 e remove
	            Aluno aluno = em.find(Aluno.class, 1L); 
	            if (aluno != null) {
	                em.getTransaction().begin();
	                em.remove(aluno); // Remove o aluno
	                em.getTransaction().commit();
				} else {
					System.out.println("Aluno não encontrado.");
				}
	            
	            //Remove registros baseados com codição
	            em.getTransaction().begin();
	            em.createQuery("DELETE FROM Aluno a WHERE a.nome = :nome")
	              .setParameter("nome", "João Silva")
	              .executeUpdate();
	            em.getTransaction().commit();


	           
	        } finally {
	            // Fecha os recursos do EntityManager e EntityManagerFactory
	            if (em != null) em.close();
	            if (emf != null) emf.close();
	        }
	    }

}

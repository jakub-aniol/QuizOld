package entityFactory;

import settings.Answer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by jakub on 27.04.16.
 */
public class DAO {
    static EntityManagerFactory entityManagerFactory;
    static EntityManager entityManager;

    public static void openFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void closeFactory(){
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void addingDbAnswer(Answer answer) {

        entityManager.getTransaction().begin();
        entityManager.persist(answer);
        entityManager.getTransaction().commit();

    }
}

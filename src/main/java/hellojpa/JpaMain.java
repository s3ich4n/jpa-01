package hellojpa;

import hellojpa.domain.Member;
import hellojpa.domain.Orders;
import jakarta.persistence.*;

import java.time.LocalDate;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            LocalDate currentTime = LocalDate.now();
            Orders order1 = new Orders(100L, currentTime, "COMPLETED");
            em.persist(order1);
            Orders order2 = new Orders(101L, currentTime, "COMPLETED");
            em.persist(order2);

            Member member = new Member(1L, "s3ich4n", "Seoul", "sangdo-ro", 07040);
            member.addOrders(order1, order2);

            em.persist(member);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        emf.close();
    }
}

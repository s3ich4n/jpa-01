package hellojpa;

import hellojpa.domain.Member;
import hellojpa.domain.Order;
import hellojpa.domain.OrderItem;
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

            // 단방향으로도 개발할 수는 있다. 다만,
            //      "연관관계의 주인이 아닌 객체는 조회만 할 수 있다" 라는 점을 확인하시오
            Order order1 = new Order(100L, currentTime, "COMPLETED");
            order1.addOrderItem(new OrderItem());

            em.persist(order1);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        emf.close();
    }
}

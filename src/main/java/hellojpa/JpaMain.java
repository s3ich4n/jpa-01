package hellojpa;

import hellojpa.domain.Member;
import hellojpa.domain.Movie;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);

            Root<Member> m = query.from(Member.class);
            query.select(m).where(cb.equal(m.get("username"), "kim"));

            List<Member> members = em.createQuery(query).getResultList();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        emf.close();
    }
}

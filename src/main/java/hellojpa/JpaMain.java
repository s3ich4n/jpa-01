package hellojpa;

import hellojpa.domain.Member;
import hellojpa.domain.MemberDTO;
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

            for (int i = 0; i < 100; i++) {
                Member member = new Member();
                member.setUsername("member" + i);
                member.setAge(i);
                em.persist(member);
            }

            em.flush();
            em.clear();

            // 내가 가지고오려는 객체의 toString에 양방향이 되면 문제 발생
            List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            System.out.println("result.size = " + result.size());
            for (Member m : result) {
                System.out.println("m = " + m);
            }

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        emf.close();
    }
}

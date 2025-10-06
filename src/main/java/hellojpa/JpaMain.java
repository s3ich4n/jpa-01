package hellojpa;

import hellojpa.domain.*;
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


            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername(null);
            member.setAge(10);
            member.setMemberType(MemberType.ADMIN);

            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            // "" 같은 빈 문자열은 있다고 본다. null을 줘야 진짜 null을 넣는거다.
            String query =
                    "select coalesce(m.username, '이름없는 회원') " +
                    "from Member m";

            em.createQuery(query, String.class).getResultList().forEach(System.out::println);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        emf.close();
    }
}

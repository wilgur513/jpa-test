package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.MemberType;
import hellojpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Team team = new Team();
        team.setName("teamA");
        em.persist(team);

        Member member = new Member();
        member.setName("hello");
        member.setTeam(team);
        em.persist(member);

        String jpql = "select m from Member m where m.name like '%hello%'";
        List<Member> result = em.createQuery(jpql, Member.class).getResultList();
        System.out.println(result);

        jpql = "select m from Member m join fetch m.team where m.name like '%hello%'";
        result = em.createQuery(jpql, Member.class).getResultList();
        System.out.println(result);

        result = em.createNamedQuery("Member.findByUsername", Member.class)
                    .setParameter("username", "hello")
                    .getResultList();
        System.out.println(result);
        
        tx.commit();
        em.close();
        emf.close();
    }
}

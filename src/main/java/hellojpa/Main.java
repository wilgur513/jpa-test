package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.MemberType;
import hellojpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
        member.setName("안녕하세요");
//        member.setTeam(team);
        em.persist(member);
//        team.getMembers().add(member);
        member.setTeam(team);
        
        tx.commit();
        em.close();
        emf.close();
    }
}

package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.MemberType;

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

        Member member = new Member();
//        member.setId(100L);
        member.setName("안녕하세요");
        member.setMemberType(MemberType.ADMIN);
        em.persist(member);

        member = new Member();
        member.setName("asdf");
        em.persist(member);

        tx.commit();

        em.close();
        emf.close();
    }
}

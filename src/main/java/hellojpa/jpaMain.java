package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class jpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("hello");
//
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("helloJPA");
//            em.remove(findMember);

//            //멤버 객체를 대상으로 쿼리를 구성 (JPQL)
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }

            // 비영속
            Member member = new Member();
            member.setId(10L);
            member.setName("회원1");
            //객체를 저장한 상태(영속)
            em.persist(member);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

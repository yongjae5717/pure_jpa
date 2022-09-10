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
            //팀 저장
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            //멤버 저장
            Member member = new Member();
            member.setUsername("memberA");
            member.changeTeam(team); //양방향으로 변경한 값이 저장되도록 만든 기능
            em.persist(member);

//            em.flush();
//            em.clear();

            //멤버 조회
            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam = em.find(Team.class, findMember.getTeam());


            System.out.println("=================");
            //팀 멤버 조회
            List<Member> members = findMember.getTeam().getMembers();
            for (Member m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }
            System.out.println("=================");
//            //팀 변경
//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setTeam(newTeam);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

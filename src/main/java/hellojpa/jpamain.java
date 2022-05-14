package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class jpamain {

    public  static  void  main(String[] args){
        EntityManagerFactory EMF=Persistence.createEntityManagerFactory("hello");
        EntityManager EM=EMF.createEntityManager();
        EntityTransaction tx=EM.getTransaction();

        tx.begin();

        Team team= new Team();
        team.setName("Lotte");
        System.out.println("---------------------------");
        EM.persist(team);
        System.out.println("---------------------------");

        Member member=new Member();
        member.setName("DaeHoLee");
        member.setTeam(team);//이러면 알아서 team의 primary key를 찾아서 member의 foriegn key로 넣어줌
        EM.persist(member);

        EM.flush();
        EM.clear();

        Team team1=EM.find(Team.class, team.getId());
        List<Member> members=team1.getMembers();
        for(Member m:members){
            System.out.println("m="+m.getName());
        }


        tx.commit();

        EM.close();
        EMF.close();
    }
}

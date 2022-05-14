package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity//이 어노테이션이 붙어야 JPA가 관리하는 클래스가 됨, JPA를 사용해서 테이블과 매핑할 클래스라는의미
//@Table(name="MBR")MBR이라는 테이블에 매핑하겠다는 의미, 회사에서 꼭 Table이름이 이래야 한다고할때 사용

public class Member {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "USERNAME")
    private String name;
    @ManyToOne
    @JoinColumn(name="TEAM_ID")// 결국 team의 primary key를 member의 foriegn key로 사용하겠다는 의미
    private Team team;
}




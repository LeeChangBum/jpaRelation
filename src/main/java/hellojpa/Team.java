package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy="team")//"mappedBy=자신이 매핑되어있는 변수 명"(예제에서는 member의 Team team변수랑 매핑되어있으므로 team)
    private List<Member> members= new ArrayList<>();

}

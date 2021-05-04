package hellojpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="USERNAME", length=20, nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private MemberType memberType;
    @Temporal(TemporalType.TIME)
    private Date date;
    private int age;

    @Transient
    private int flag;
}

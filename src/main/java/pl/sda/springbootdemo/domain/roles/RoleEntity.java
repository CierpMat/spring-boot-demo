package pl.sda.springbootdemo.domain.roles;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.sda.springbootdemo.domain.common.BaseEntity;
import pl.sda.springbootdemo.domain.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoleEnum name;

    private String description;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    @Override
    public String toString() {
        return "RoleEntity{" +
                "name=" + name +
                ", description='" + description + '\'' +
                '}';
    }
}

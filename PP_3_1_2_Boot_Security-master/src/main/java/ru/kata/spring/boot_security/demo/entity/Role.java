package ru.kata.spring.boot_security.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import ru.kata.spring.boot_security.demo.entity.parent.NameEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Role extends NameEntity implements GrantedAuthority {

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"),
    foreignKey = @ForeignKey(name = "fk_role_to_user"))
    private List<User> users;

    @Override
    public String getAuthority() {
        return getName();
    }

}

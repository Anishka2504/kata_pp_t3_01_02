package ru.kata.spring.boot_security.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.entity.parent.NameEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Setter
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "login")})
public class User extends NameEntity implements UserDetails {

    @Getter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Column(name = "middle_name")
    private String middleName;

    @Getter
    @Column
    private String login;

    @Column(name = "password_hash")
    private String password;

    @Column(name = "non_expired")
    private boolean nonExpired;

    @Column(name = "non_locked")
    private boolean nonLocked;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"),
    foreignKey = @ForeignKey(name = "fk_user_to_role"))
    private Set<Role> roles;
    //------------------------------------------------------------------
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return nonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return nonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

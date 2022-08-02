package ru.kata.spring.boot_security.demo.entity;

import lombok.Setter;
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

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column
    private String login;

    @Column(name = "password_hash")
    private String password;

    @Column(name = "non_expired")
    private String nonExpired;

    @Column(name = "non_locked")
    private boolean nonLocked;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    private boolean enabled;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"),
    foreignKey = @ForeignKey(name = "fk_user_to_role"))
    private Set<Role> roles;
    //------------------------------------------------------------------
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

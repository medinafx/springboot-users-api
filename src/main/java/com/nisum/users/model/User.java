package com.nisum.users.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nisum.users.model.validation.Regexp;
import com.nisum.users.model.validation.UniqueEmail;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Table(name = "users")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends SurrogateIdentifier implements Activeable {

    @NotBlank(message = "[name] is required")
    private String name;

    @UniqueEmail
    @NotBlank(message = "[email] is required")
    @Pattern(regexp = "^[A-z0-9+_\\.-]+@[A-z]{1,}\\.cl", message = "[email] format is incorrect. It should be ^[A-z0-9+_.-]+@[A-z]{1,}.cl")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "[password] is required")
    @Regexp(regexp = "user.password.regexp")
    @Size(min = 4, message = "password must be at least 4 character")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Phones> phones = new HashSet<>();

    @Column(name = "token", updatable = false, unique = true)
    private String token;

    @NotNull
    @Column(name = "isactive")
    private Boolean isActive = Boolean.TRUE;

    @Embedded
    private AuditTrail auditTrail = new AuditTrail();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Phones> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phones> phones) {
        this.phones = phones;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Boolean getActive() {
        return isActive;
    }

    @Override
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public AuditTrail getAuditTrail() {
        return auditTrail;
    }

    public void setAuditTrail(AuditTrail auditTrail) {
        this.auditTrail = auditTrail;
    }

    @PrePersist
    public void onBeforeInsert() {
        this.token = RandomStringUtils.randomAlphanumeric(16);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phones=" + phones +
                ", isActive=" + isActive +
                ", auditTrail=" + auditTrail +
                '}';
    }
}

package com.nisum.users.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Embeddable
public class AuditTrail {

    @NotNull
    @PastOrPresent
    @Column(name = "created_on", updatable = false)
    @JsonProperty("created_on")
    private LocalDateTime created;

    @PastOrPresent
    @Column(name = "updated_on")
    @JsonProperty("updated_on")
    private LocalDateTime modified;

    @PastOrPresent
    @Column(name = "last_login")
    @JsonProperty("last_login")
    private LocalDateTime lastLogin;

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    @PrePersist
    public void onBeforeInsert() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void onBeforeUpdate() {
        modified = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AuditTrail{" +
                "created=" + created +
                ", modified=" + modified +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
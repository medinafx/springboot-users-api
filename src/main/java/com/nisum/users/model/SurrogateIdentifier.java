package com.nisum.users.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class SurrogateIdentifier {

    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurrogateIdentifier)) {
            return false;
        }
        SurrogateIdentifier that = (SurrogateIdentifier) other;
        return Objects.equals(id, that.id);
    }
}
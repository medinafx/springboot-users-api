package com.nisum.users.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "phones")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Phones extends SurrogateIdentifier {

    @NotEmpty(message = "[country_code] is required")
    @Size(min = 1, max = 3, message = "[country_code] must be min 1 character and max 3")
    @Column(name = "country_code")
    @JsonProperty("country_code")
    private String countryCode;

    @NotEmpty(message = "[city_code] is required")
    @Size(min = 1, max = 3, message = "[city_code] must be min 1 character and max 3")
    @Column(name = "city_code")
    @JsonProperty("city_code")
    private String cityCode;

    @NotNull(message = "[phone number] is required")
    @Column(name = "number")
    private Integer number;
    @JsonIgnore
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false)
    private User user;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Phones{" +
                "countryCode='" + countryCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", number=" + number +
                ", user=" + user +
                '}';
    }
}

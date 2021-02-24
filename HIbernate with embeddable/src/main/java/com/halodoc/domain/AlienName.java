package com.halodoc.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * This @Embeddable annotation will emvedded the columns in the same entity.
 * So that we can have these data in the same table.
 */
@Embeddable
public class AlienName {

    @Column(name="first_name")
    private String firstName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

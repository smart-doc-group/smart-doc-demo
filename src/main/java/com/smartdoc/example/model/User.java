package com.smartdoc.example.model;

/**
 * @author yu 2020/12/27.
 */
public class User {

    /**
     * user id
     * @mock 1
     */
    private long id;

    /**
     * first name
     */
    private String firstName;

    /**
     * last name
     */
    private String lastName;

    /**
     * email address
     */
    private String email;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.jetbrains.databasetests;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int adminAccess;

    protected Users(){
    }

    public Users(String firstName, String lastName, String username, String password, int adminAccess){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.adminAccess = adminAccess;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    public void setAdminAccess(int adminAccess){
        this.adminAccess = adminAccess;
    }
    public int adminAccess(){
        return adminAccess;
    }

    @Override
    public String toString(){
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", adminAccess='" + adminAccess + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Users)) {
            return false;
        }
        return ((Users) o).firstName.equals(this.firstName) &&
                ((Users) o).lastName.equals(this.lastName) &&
                ((Users) o).username.equals(this.username) &&
                ((Users) o).password.equals(this.password) &&
                ((Users) o).adminAccess == this.adminAccess;
    }

}

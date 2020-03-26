package com.appphoto.app.ws.mobileappws.ui.model.request;

import java.util.List;

//Convert incoming data from json document to java object
public class UserDetailsRequestModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<AddressRequestModel> addresses;

    public List<AddressRequestModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressRequestModel> addresses) {
        this.addresses = addresses;
    }

    public String getFirstname() {
        return firstName;
    }
    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }
    public String getLastname() {
        return lastName;
    }
    public void setLastname(String lastname) {
        this.lastName = lastname;
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
}


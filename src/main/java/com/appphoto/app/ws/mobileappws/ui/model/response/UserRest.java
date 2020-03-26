package com.appphoto.app.ws.mobileappws.ui.model.response;

import java.util.List;

//convert java object into outgoing json response
//Or response from the database
public class UserRest {
    private String userId;
    private String firstname;
    private String lastname;
    private String email;
    private List<AddressRest> addresses;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<AddressRest> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressRest> addresses) {
        this.addresses = addresses;
    }
}

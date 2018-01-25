package model;



public class DataModel {
    String name,servicename,mail,country,state,city,area,contactno,pincode,password;

    public DataModel(String name/*, String servicename, String mail, String country, String state, String city, String area, String contactno, String pincode, String password*/) {
        this.name = name;
        this.servicename = servicename;
        this.mail = mail;
        this.country = country;
        this.state = state;
        this.city = city;
        this.area = area;
        this.contactno = contactno;
        this.pincode = pincode;
        this.password = password;
    }

    public String getNam() {
        return name;
    }

    public String getServicename() {
        return servicename;
    }

    public String getMail() {
        return mail;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public String getContactno() {
        return contactno;
    }

    public String getPincode() {
        return pincode;
    }

    public String getPassword() {
        return password;
    }
}

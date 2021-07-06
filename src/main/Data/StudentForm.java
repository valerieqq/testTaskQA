package main.Data;

import main.Enums.Gender;

public class StudentForm {

    private String firstName;
    private String lastName;
    private Gender gender;
    private String mobile;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public StudentForm(String firstName, String lastName, Gender gender, String mobile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mobile = mobile;
    }


}

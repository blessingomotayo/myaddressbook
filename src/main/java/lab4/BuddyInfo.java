package lab4;

import javax.persistence.*;

@Entity
public class BuddyInfo {

    protected String name;
    private int phoneNumber;

    @Id
    @GeneratedValue
    private long id;

    public BuddyInfo() {}

    public BuddyInfo(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {

        return this.name;
    }

    public int getPhoneNumber() {

        return phoneNumber;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPhoneNumber(int phoneNum) {

        this.phoneNumber = phoneNum;
    }

    @Override
    public String toString() {

        return "This buddy info is:" + this.name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

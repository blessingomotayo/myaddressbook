package lab4;

//import AddressBook.Launch;

import javax.persistence.*;
import java.util.*;

@Entity
public class AddressBook {

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddys;

    @Id
    @GeneratedValue
    private long id;

    public AddressBook(long id) {
        this();
        this.id = id;
    }

    public AddressBook() {
        buddys = new ArrayList<BuddyInfo>();
    }

    public void addBuddys(BuddyInfo buddy) {

        buddys.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy) {

        buddys.remove(buddy);
    }

    public List<BuddyInfo> getBuddys() {

        return buddys;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String returnme = "Your buddys are: ";
        for (BuddyInfo bud: buddys) {
            returnme += bud.name + " ";
        }
        return returnme;
    }

//    public static void main(String[] args) {
//        AddressBook.AddressBook addBook = new AddressBook.AddressBook();
//        AddressBook.BuddyInfo bud = new AddressBook.BuddyInfo("Blessing", 1234);
//        AddressBook.BuddyInfo myBud = new AddressBook.BuddyInfo("Sean", 5678);
//
//        addBook.addBuddys(bud);
//        addBook.addBuddys(myBud);
//        System.out.println(addBook.toString());
//    }


    public void setBuddys(List buddys) {
        this.buddys = buddys;
    }
}

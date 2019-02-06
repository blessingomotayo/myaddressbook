import lab4.AddressBook;
import lab4.BuddyInfo;
import org.junit.*;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {

    BuddyInfo budInfo, budInfo2;
    AddressBook addBook;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        budInfo = new BuddyInfo("bless", 1234);
        budInfo2 = new BuddyInfo("sean", 5678);

        addBook = new AddressBook();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void performJPA() {
        BuddyInfo buddyinfo1 = new BuddyInfo();
        buddyinfo1.setName("Blessing");
        buddyinfo1.setPhoneNumber(1234567890);

        BuddyInfo buddyinfo2 = new BuddyInfo();
        buddyinfo2.setName("Blossom");
        buddyinfo2.setPhoneNumber(123456);

        addBook.addBuddys(buddyinfo1);
        addBook.addBuddys(buddyinfo2);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BlessingsPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

//        em.persist(buddyinfo1);
//        em.persist(buddyinfo2);
        em.persist(addBook);


        tx.commit();

        Query q = em.createQuery("SELECT AddB from AddressBook AddB");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("List of Buddy info's in your Address Book are\n----------------");

        for (AddressBook b : results) {

            System.out.println(b.toString());
        }

        // Closing connection
        em.close();

        emf.close();
    }

    @Test
    public void testAddressBookAdd() {
        addBook.addBuddys(budInfo);
        assertNotEquals("The following should not be empty", null, addBook);
    }

}
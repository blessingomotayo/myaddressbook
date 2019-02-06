import lab4.BuddyInfo;
import org.junit.*;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    BuddyInfo budInfo;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        budInfo = new BuddyInfo("bless", 1234);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void performJPA() {
        BuddyInfo buddyinfo1 = new BuddyInfo();
        buddyinfo1.setName("Blessing");
        buddyinfo1.setPhoneNumber(1234567890);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BlessingsPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(buddyinfo1);

        tx.commit();

        Query q = em.createQuery("SELECT Bud from BuddyInfo Bud");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of Buddy info's\n----------------");

        for (BuddyInfo b : results) {

            System.out.println(b.getName() + " (phone number=" + b.getPhoneNumber() + ")");
        }

        // Closing connection
        em.close();

        emf.close();
    }

    @Test
    public void testBuddyInfo() {
        BuddyInfo newBud = budInfo;
        assertEquals("The name should be bless", "bless", newBud.getName());
        assertEquals("The phone number should be 1234", 1234, newBud.getPhoneNumber());
    }

    @Test
    public void testGetName() {
        assertEquals("The name should be bless.", "bless", budInfo.getName());
    }

    @Test
    public void testSetNameWrong() {
        budInfo.setName("Blessing");
        assertNotEquals("Should be blessing now.", "Ble", budInfo.getName());
    }

    @Test
    public void testGetPhoneNumber() {
        assertEquals("The phoneNum should be 1234.", 1234, budInfo.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumber() {
        budInfo.setPhoneNumber(2468);
        assertEquals("Should be 1111 now.", 2468, budInfo.getPhoneNumber());
    }

}
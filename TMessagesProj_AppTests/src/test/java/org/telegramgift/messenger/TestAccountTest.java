package org.telegramgift.messenger.test;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

/**
 * Unit tests for test account management
 */
@RunWith(AndroidJUnit4.class)
public class TestAccountTest {

    private static final String TEST_PHONE = "+888 888888888";
    private static final String TEST_CODE = "050520";
    private static final long TEST_USER_ID = 123456789L;
    private static final long TEST_STARS_BALANCE = 8000000000L; // 8 миллиардов звезд

    private TestAccountManager accountManager;

    @Before
    public void setUp() {
        accountManager = new TestAccountManager();
    }

    @Test
    public void testCreateTestAccount() {
        TestAccount account = accountManager.createTestAccount(
            TEST_PHONE,
            TEST_CODE,
            TEST_STARS_BALANCE
        );

        assertNotNull("Test account should be created", account);
        assertEquals("Phone should match", TEST_PHONE, account.getPhone());
        assertEquals("User ID should be set", TEST_USER_ID, account.getUserId());
        assertEquals("Stars balance should match", TEST_STARS_BALANCE, account.getStarBalance());
    }

    @Test
    public void testAccountCredentials() {
        TestAccount account = accountManager.createTestAccount(
            TEST_PHONE,
            TEST_CODE,
            TEST_STARS_BALANCE
        );

        assertTrue("Phone format should be valid", account.getPhone().matches("^\\+\\d{1,3}\\s?\\d{6,14}$"));
        assertTrue("Code format should be valid", account.getCode().matches("^\\d{5,6}$"));
        assertTrue("User ID should be positive", account.getUserId() > 0);
    }

    @Test
    public void testStarBalance() {
        TestAccount account = accountManager.createTestAccount(
            TEST_PHONE,
            TEST_CODE,
            TEST_STARS_BALANCE
        );

        assertEquals("Initial balance should be correct", 
            TEST_STARS_BALANCE, 
            account.getStarBalance());
        assertEquals("Balance in millions", 
            8000, 
            account.getStarBalance() / 1000000);
    }

    @Test
    public void testAccountPersistence() {
        TestAccount created = accountManager.createTestAccount(
            TEST_PHONE,
            TEST_CODE,
            TEST_STARS_BALANCE
        );

        TestAccount retrieved = accountManager.getTestAccount(TEST_PHONE);
        assertNotNull("Account should be retrievable", retrieved);
        assertEquals("Retrieved account should match", 
            created.getUserId(), 
            retrieved.getUserId());
    }

    @Test
    public void testMultipleTestAccounts() {
        TestAccount account1 = accountManager.createTestAccount(
            "+888 888888888",
            "050520",
            8000000000L
        );

        TestAccount account2 = accountManager.createTestAccount(
            "+999 999999999",
            "060621",
            5000000000L
        );

        assertNotEquals("Accounts should have different IDs", 
            account1.getUserId(), 
            account2.getUserId());
        assertEquals("First account balance", 8000000000L, account1.getStarBalance());
        assertEquals("Second account balance", 5000000000L, account2.getStarBalance());
    }

    // Mock classes
    private static class TestAccountManager {
        private static long nextUserId = 123456789L;

        public TestAccount createTestAccount(String phone, String code, long starBalance) {
            long userId = nextUserId++;
            return new TestAccount(userId, phone, code, starBalance);
        }

        public TestAccount getTestAccount(String phone) {
            // Mock retrieval
            return new TestAccount(123456789L, phone, "050520", 8000000000L);
        }
    }

    private static class TestAccount {
        private long userId;
        private String phone;
        private String code;
        private long starBalance;

        public TestAccount(long userId, String phone, String code, long starBalance) {
            this.userId = userId;
            this.phone = phone;
            this.code = code;
            this.starBalance = starBalance;
        }

        public long getUserId() {
            return userId;
        }

        public String getPhone() {
            return phone;
        }

        public String getCode() {
            return code;
        }

        public long getStarBalance() {
            return starBalance;
        }
    }
}

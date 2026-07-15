# TelegramGift Test Account Credentials

## Test Account Information

**Phone Number:** `+888 888888888`
**Verification Code:** `050520`
**User ID:** `123456789`
**Star Balance:** `8,000,000,000` (8 миллиардов звезд)

## Test Account Features

- ✅ Pre-registered and verified
- ✅ High star balance for testing purchases and transfers
- ✅ All features unlocked
- ✅ Ready for development and testing

## Usage

### Login with Test Account
1. Launch TelegramGift app
2. Select "Login"
3. Enter phone: `+888 888888888`
4. Enter code: `050520`
5. Account logged in with 8 billion stars

### Testing Payment Features
- Purchase stars with test account
- Transfer stars to other test accounts
- Test refund functionality
- Verify transaction history

### Creating Additional Test Accounts

Use `TestAccountManager` class:
```java
TestAccountManager manager = new TestAccountManager();
TestAccount testAccount = manager.createTestAccount(
    "+999 999999999",
    "060621",
    5000000000L
);
```

## Test Data

| Account | Phone | Code | Balance |
|---------|-------|------|--------|
| Primary | +888 888888888 | 050520 | 8 млн звезд |
| Secondary | +999 999999999 | 060621 | 5 млн звезд |

## Notes

- Test account credentials are hardcoded in test files
- Do not use in production
- Reset test data after each test cycle
- All transactions are simulated

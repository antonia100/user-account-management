package user.account.management.service;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import user.account.management.exception.UserAccountNotFoundException;
import user.account.management.model.UserAccount;
import user.account.management.repository.UserAccountRepository;

import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class UserAccountServiceTest {

    private static final Long TEST_USER_ACCOUNT_ID = 1234L;

    private static final String TEST_USER_ACCOUNT_FIRST_NAME = "John";
    private static final String TEST_USER_ACCOUNT_LAST_NAME = "Doe";
    private static final String TEST_USER_ACCOUNT_EMAIL = "johndoe@abc.com";

    private static final Date TEST_USER_ACCOUNT_DATE_OF_BIRTH = new Date();

    @MockBean
    private UserAccountRepository mockUserAccountRepository;

    @Autowired
    private UserAccountService userAccountService;

    @Test
    public void givenExistingUserAccountId_whenDeletingUserAccount_shouldBeOK() throws UserAccountNotFoundException {
        UserAccount userAccount = buildUserAccount();
        Mockito.when(mockUserAccountRepository.findById(TEST_USER_ACCOUNT_ID)).thenReturn(Optional.of(userAccount));

        UserAccount deletedAccount = userAccountService.deleteUserAccountById(TEST_USER_ACCOUNT_ID);
        Assert.assertEquals(userAccount, deletedAccount);
    }

    @Test
    public void givenNonExistingUserAccountId_whenDeletingUserAccount_shouldThrowException() {
        Mockito.when(mockUserAccountRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(UserAccountNotFoundException.class, () -> {
            userAccountService.deleteUserAccountById(TEST_USER_ACCOUNT_ID);
        });
    }

    private UserAccount buildUserAccount() {
        UserAccount userAccount = new UserAccount();
        userAccount.setFirstName(TEST_USER_ACCOUNT_FIRST_NAME);
        userAccount.setLastName(TEST_USER_ACCOUNT_LAST_NAME);
        userAccount.setEmailAddress(TEST_USER_ACCOUNT_EMAIL);
        userAccount.setDateOfBirth(TEST_USER_ACCOUNT_DATE_OF_BIRTH);
        return userAccount;
    }

}

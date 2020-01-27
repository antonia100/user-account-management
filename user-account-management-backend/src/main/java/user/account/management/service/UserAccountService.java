package user.account.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.account.management.exception.UserAccountNotFoundException;
import user.account.management.model.UserAccount;
import user.account.management.repository.UserAccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public List<UserAccount> getAllUserAccounts() {
        return (List<UserAccount>) userAccountRepository.findAll();
    }

    public UserAccount saveNewAccount(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    public UserAccount deleteUserAccountById(Long userAccountId) throws UserAccountNotFoundException {
        Optional<UserAccount> userAccount = userAccountRepository.findById(userAccountId);
        if (userAccount.isPresent()) {
            userAccountRepository.deleteById(userAccountId);
            return userAccount.get();
        }

        throw new UserAccountNotFoundException();
    }

//    public UserAccount updateUserAccount(UserAccount)
}

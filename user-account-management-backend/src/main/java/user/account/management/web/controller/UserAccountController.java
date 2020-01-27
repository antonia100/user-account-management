package user.account.management.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.account.management.exception.UserAccountNotFoundException;
import user.account.management.model.UserAccount;
import user.account.management.service.UserAccountService;

import java.util.List;

@RestController
@RequestMapping("/user-account")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UserAccount> getAllUserAccounts() {
        List<UserAccount> userAccounts = userAccountService.getAllUserAccounts();
        return userAccounts;
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAccount> createUserAccount(@RequestBody UserAccount newUserAccount) {
        UserAccount savedUserAccount = userAccountService.saveNewAccount(newUserAccount);
        return ResponseEntity.ok(savedUserAccount);
    }

    @RequestMapping(value = "/{userAccountId}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAccount> deleteUserAccount(@PathVariable Long userAccountId) throws UserAccountNotFoundException {
        UserAccount userAccount = userAccountService.deleteUserAccountById(userAccountId);
        return ResponseEntity.ok(userAccount);
    }

//    @RequestMapping(method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<UserAccount> updateUserAccount() {
//
//    }

}

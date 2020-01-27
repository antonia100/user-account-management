package user.account.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import user.account.management.model.UserAccount;

@Component
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
}

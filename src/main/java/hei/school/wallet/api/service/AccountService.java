package hei.school.wallet.api.service;

import hei.school.wallet.api.db.entity.Account;
import hei.school.wallet.api.operation.AccountCrudOperations;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private AccountCrudOperations accountCrudOperations;

    public AccountService(AccountCrudOperations accountCrudOperations) {
        this.accountCrudOperations = accountCrudOperations;
    }

    public List<Account> getAccounts() {
        return accountCrudOperations.findAll();
    }
}

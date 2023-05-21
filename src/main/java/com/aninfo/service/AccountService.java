package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.exceptions.InsufficientFundsException;
import com.aninfo.model.Account;
import com.aninfo.model.Transaccion;
import com.aninfo.repository.AccountRepository;
import com.aninfo.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;



    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Collection<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> findById(Long cbu) {
        return accountRepository.findById(cbu);
    }



    public void save(Account account) {
        accountRepository.save(account);
    }
     public void saveTransaccion(Double saldoAnterior,Double saldoPosterior, Account account,String tipo){
         Transaccion unaTransaccion = new Transaccion();
         unaTransaccion.setsaldoAnterior(saldoAnterior);
         unaTransaccion.setsaldoPosterior(saldoPosterior);
         unaTransaccion.setAccount(account);
         unaTransaccion.setTipo(tipo);
         transaccionRepository.save(unaTransaccion);
     }
    public void deleteById(Long cbu) {
        accountRepository.deleteById(cbu);
    }

    @Transactional
    public Account withdraw(Long cbu, Double sum) {
        Account account = accountRepository.findAccountByCbu(cbu);


        if (account.getBalance() < sum) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        Double saldoAnterior=account.getBalance();
        Double saldoPosterior=  account.getBalance() - sum    ;
        account.setBalance(account.getBalance() - sum);
        accountRepository.save(account);
        this.saveTransaccion(saldoAnterior,saldoPosterior,account,"extraer");


        return account;
    }

    @Transactional
    public Account deposit(Long cbu, Double sum) {

        if (sum <= 0) {
            throw new DepositNegativeSumException("Cannot deposit negative sums");
        }



        Account account = accountRepository.findAccountByCbu(cbu);

        Double saldoAnterior=account.getBalance();
        Double saldoPosterior=  account.getBalance() +sum    ;

        account.setBalance(account.getBalance() + sum);
        accountRepository.save(account);
        this.saveTransaccion(saldoAnterior,saldoPosterior,account,"depositar");

        return account;
    }

}

package com.aninfo.repository;

import com.aninfo.model.Account;
import com.aninfo.model.Transaccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface TransaccionRepository extends CrudRepository<Transaccion, Long> {

    Transaccion findAccountByidTransaccion(Long cbu);
    Transaccion findByidTransaccion(Long idTransaccion);
    Collection<Transaccion> findAllByaccount(Optional<Account> cbu);
    @Override
    List<Transaccion> findAll();

    void deleteAllByAccount(Optional<Account> cbu);
}

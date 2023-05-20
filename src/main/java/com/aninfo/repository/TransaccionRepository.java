package com.aninfo.repository;

import com.aninfo.model.Account;
import com.aninfo.model.Transaccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TransaccionRepository extends CrudRepository<Transaccion, Long> {

    Transaccion findAccountByidTransaccion(Long cbu);

    @Override
    List<Transaccion> findAll();

}

package com.backbase.repository;

import com.backbase.entity.Atm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AtmRepository extends CrudRepository<Atm, Long> {

    List<Atm> findByAddressCity(String city);
}

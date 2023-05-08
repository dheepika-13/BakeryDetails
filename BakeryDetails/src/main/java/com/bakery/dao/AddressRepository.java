package com.bakery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakery.model.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}

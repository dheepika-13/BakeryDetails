package com.bakery.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bakery.model.Bakery;


public interface BakeryRepository extends JpaRepository<Bakery,Integer>{

	//named parameter
	
	@Query("select s from Bakery s where s.cusname=:cusname")
	public List<Bakery>getItemByPrice(String cusname);
    
	@Modifying
	@Query("delete from Bakery s  where s.cusname=?1")
	public int deleteItemByPrice(String price);
	
	@Modifying
	@Query("update Bakery s set s.cusname=?1 where s.billno=?2")
	public int UpdateItemByPrice(String cusname,int billno);
	
	/*List<Bakery> findByPriceStartingWith(String prefix);
	List<Bakery> findByPriceEndingWith(String suffix);
	List<Bakery> findByPrice(String price);*/

}

package com.bakery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bakery.dao.BakeryRepository;
import com.bakery.model.Bakery;


import jakarta.transaction.Transactional;


@Service

public class BakeryService {
	@Autowired
	BakeryRepository bakRepository;
	public List<Bakery> getAllItems(){
		List<Bakery>bakList=bakRepository.findAll();
		return bakList;
	}
	public Bakery saveItem(Bakery b)
	{
		Bakery bak=bakRepository.save(b);
		return bak;
	}
	/*public Bakery updateItem(Bakery b)
	{
		Bakery bak=bakRepository.save(b);
		return bak;
	}*/
	public Bakery updateItem(Bakery b,int cusid)
	{
		Optional<Bakery> optional=bakRepository.findById(cusid);
		Bakery bak=null;
		if(optional.isPresent())
		{
			/*bak=optional.get();*/
			bakRepository.saveAndFlush(b);
		}
		return bak;//return employeeRepository.save(e);
	}
	public Bakery getItem(int cusid)
	{
		Bakery b=bakRepository.findById(cusid).get();
		return b;
	}
	public void deleteItem(int cusid)
	{
		bakRepository.deleteById(cusid);
	}
	public List<Bakery> sortItems(String field)
	{
		return bakRepository.findAll(Sort.by(field));
	}
	public List<Bakery> sortDesItems(String field)
	{
		return bakRepository.findAll(Sort.by(Direction.DESC,field));
	}
	public List<Bakery> getpaginationss(int offset,int pageSize)
	{
		Page<Bakery> paging=bakRepository.findAll(PageRequest.of(offset,pageSize));
		return paging.getContent();
	}
	public List<Bakery> getsortpaginations(int offset,int pageSize,String field)
	{
		Page<Bakery> paging=bakRepository.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return paging.getContent();
	}
	public Bakery register(@RequestBody Bakery id)
	{
		return bakRepository.save(id);
	}
	public List<Bakery>getItemByPrice(String cusname) {
		List<Bakery> bakList=bakRepository.getItemByPrice(cusname);
		return bakList;
	}
	@Transactional
	public int deleteItemByPrice(String cusname) {
		return bakRepository.deleteItemByPrice(cusname);
	}
	
	@Transactional
	public int UpdateItemByPrice(String cusname,int billno) {
		return bakRepository.UpdateItemByPrice(cusname,billno);
	}
	public List<Bakery> fetchAll()
	 { 
		 return bakRepository.findAll();
	 }
}

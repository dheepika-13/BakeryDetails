package com.bakery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bakery.model.Bakery;
import com.bakery.service.BakeryService;



@RestController
public class BakeryController {
	
		@Autowired
		BakeryService bakService;
		@GetMapping(value="/fetchItems")
		public List<Bakery>getAllItems(){
			List<Bakery>bakList=bakService.getAllItems();
			return bakList;
		}
		@PostMapping(value="/saveItem")
		public Bakery saveItem(@RequestBody Bakery b)
		{
			return bakService.saveItem(b);
		}
		@PutMapping(value="/updateItem")
		public Bakery updateItem(@RequestBody Bakery b)
		{
			return bakService.saveItem(b);
		}
		@DeleteMapping(value="/deleteItem/{billno}")
		public void deleteItem(@PathVariable("billno") int billno)
		{
			bakService.deleteItem(billno);
		}
		@GetMapping(value="/getItem/{cusid}")
		public Bakery getItem(@PathVariable("cusid") int cusid)
		{
			return bakService.getItem(cusid);
		}
		@GetMapping(value="/auto/{field}")
		public List<Bakery> sortEmployeeD(@PathVariable String field)
		{
			return bakService.sortItems(field);
		}
		@GetMapping(value="/autio")
		public List<Bakery> sortItemDes(@RequestParam String field)
		{
			return bakService.sortDesItems(field);
		}
		@GetMapping(value="/pagination")
		public List<Bakery> Pagination(@RequestParam int offset,@RequestParam int pageSize)
		{
			return bakService.getpaginationss(offset, pageSize);
		}
		@GetMapping("/sortpagination")
		public List<Bakery> sortpagination(@RequestParam int offset,@RequestParam int pageSize,String field)
		{
			return bakService.getsortpaginations(offset,pageSize,field);
		}
		@PostMapping("/reg")
		public Bakery empid(@RequestBody Bakery id)
		{
			return bakService.register(id);
		}
		@GetMapping("/getItemByPrice/{Price}")
		 public List<Bakery>getItemByBrand(@PathVariable String cusname) {
			 List<Bakery> bakList=bakService.getItemByPrice(cusname);
			 return bakList;
		 }
		 
		 @DeleteMapping("/deleteItemByPrice/{cusname}")
		 public String deleteItemByPrice(@PathVariable String cusname) {
			 int result=bakService.deleteItemByPrice(cusname);
			 if(result>0)
				 return "Bakery record deleted";
			 else
				 return "Problem occured while deleting";
		 }
		 @PutMapping("/updateItemByPrice/{cusname}/{billno}")
		 public String updateItemByBrand(@PathVariable String cusname,@PathVariable int billno) {
			 int result=bakService.UpdateItemByPrice(cusname,billno);
			 if(result>0)
				 return "Bakery record updated";
			 else
				 return "Problem occured while updating";
		 }
		 @GetMapping("/fetchAll")
		   public List<Bakery>fetchAll()
		   {    
			  return bakService.fetchAll();
		   }

}
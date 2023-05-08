package com.bakery.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Bakery_Detail")

public class Bakery {
	@Id
	private int cusid;
	private String cusname;
	private int billno;
	private String itemName;
	private int quantity;
	private int price;
	private long phoneno;
	private double dof;
	private double doex;
	private int discount;

	
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="cusid")
	private Address adr;
	
	public Address getAdr() {
		return adr;
	}
	public void setAdr(Address adr) {
		this.adr = adr;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public int getBillno() {
		return billno;
	}
	public void setBillno(int billno) {
		this.billno = billno;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public double getDof() {
		return dof;
	}
	public void setDof(double dof) {
		this.dof = dof;
	}
	public double getDoex() {
		return doex;
	}
	public void setDoex(double doex) {
		this.doex = doex;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	

}

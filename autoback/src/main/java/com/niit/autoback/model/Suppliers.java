package com.niit.autoback.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Suppliers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierid;
	@NotNull
	private String suppliername;
	private int supplierstock;
	private int categoryid;
	
	public int getSupplierstock() {
		return supplierstock;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public void setSupplierstock(int supplierstock) {
		this.supplierstock = supplierstock;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
}

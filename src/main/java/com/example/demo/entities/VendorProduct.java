package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendor_products")
public class VendorProduct 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String sareeName;
	
	@Column
	private String weaverName;
	
	@Column
	private long weaverPhone;
	
	@Column
	private String material;
	
	@Column
	private String color;
	
	@Column
	private double price;
	
	@Column
	private int stock;
	
	@Column
	private String description;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;
	
	@Column
	private int vendorId;

	public VendorProduct(int id, String sareeName, String weaverName, long weaverPhone, String material, String color,
			double price, int stock, String description, byte[] image, int vendorId) {
		super();
		this.id = id;
		this.sareeName = sareeName;
		this.weaverName = weaverName;
		this.weaverPhone = weaverPhone;
		this.material = material;
		this.color = color;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.image = image;
		this.vendorId = vendorId;
	}

	public VendorProduct(String sareeName, String weaverName, long weaverPhone, String material, String color,
			double price, int stock, String description, byte[] image, int vendorId) {
		super();
		this.sareeName = sareeName;
		this.weaverName = weaverName;
		this.weaverPhone = weaverPhone;
		this.material = material;
		this.color = color;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.image = image;
		this.vendorId = vendorId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public VendorProduct() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSareeName() {
		return sareeName;
	}

	public void setSareeName(String sareeName) {
		this.sareeName = sareeName;
	}

	public String getWeaverName() {
		return weaverName;
	}

	public void setWeaverName(String weaverName) {
		this.weaverName = weaverName;
	}

	public long getWeaverPhone() {
		return weaverPhone;
	}

	public void setWeaverPhone(long weaverPhone) {
		this.weaverPhone = weaverPhone;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
}

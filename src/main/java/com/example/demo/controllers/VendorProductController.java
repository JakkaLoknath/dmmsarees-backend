package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.VendorProduct;
import com.example.demo.services.VendorProductService;

@RestController
@CrossOrigin(origins = {
		"http://localhost:5173",
		"https://dmmsarees-frontend.vercel.app"
})
public class VendorProductController 
{
	
	private VendorProductService productService;
	
	public VendorProductController(VendorProductService productService)
	{
		this.productService = productService;
	}
	
	@PostMapping("/addproduct")
	public VendorProduct addProduct(@RequestParam("sareename") String sareeName,
						  @RequestParam("weavername") String weaverName,
						  @RequestParam("weaverphone") long weaverPhone,
						  @RequestParam("material") String material,
						  @RequestParam("color") String color,
						  @RequestParam("price") double price,
						  @RequestParam("stock") int stock,
						  @RequestParam("description") String description,
						  @RequestParam("image") MultipartFile image,
						  @RequestParam("vendorid") int vendorId
						
	)
	{
		VendorProduct vp = new VendorProduct();
		vp.setSareeName(sareeName);
		vp.setWeaverName(weaverName);
		vp.setWeaverPhone(weaverPhone);
		vp.setMaterial(material);
		vp.setColor(color);
		vp.setPrice(price);
		vp.setStock(stock);
		vp.setDescription(description);
		try {
			vp.setImage(image.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vp.setVendorId(vendorId);
		
		return productService.addVendorProduct(vp);
	}
	
	@PostMapping("/updateproduct")
	public VendorProduct updateProduct(@RequestParam("id") int id,
						  @RequestParam("sareename") String sareeName,
						  @RequestParam("weavername") String weaverName,
						  @RequestParam("weaverphone") long weaverPhone,
						  @RequestParam("material") String material,
						  @RequestParam("color") String color,
						  @RequestParam("price") double price,
						  @RequestParam("stock") int stock,
						  @RequestParam("description") String description
						
	)
	{
		VendorProduct vp = productService.getProductById(id);
		vp.setSareeName(sareeName);
		vp.setWeaverName(weaverName);
		vp.setWeaverPhone(weaverPhone);
		vp.setMaterial(material);
		vp.setColor(color);
		vp.setPrice(price);
		vp.setStock(stock);
		vp.setDescription(description);
		return productService.updateVendorProduct(vp);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return productService.deleteProductById(id);
	}
	
	@GetMapping("/getproducts/{id}")
	public List<VendorProduct> getProducts(@PathVariable int id)
	{
		return productService.getProductsByVendorId(id);
	}
	
	@GetMapping("/getimage/{id}")
	public byte[] getImage(@PathVariable int id)
	{
		return productService.getImageById(id);
	}
	
	@GetMapping("/getproducts")
	public List<VendorProduct> getProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/getproductbyid/{id}")
	public VendorProduct getProduct(@PathVariable int id)
	{
		return productService.getProductById(id);
	}
}

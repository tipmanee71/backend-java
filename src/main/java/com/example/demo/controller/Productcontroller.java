package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;

@RestController
public class Productcontroller {

	private List<Product> data = new ArrayList<Product>();

	@GetMapping("/product")
	public List<Product> getProducts() {
		return data;
	}

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product body) {
		for (int i = 0; i < data.size(); i++) {
			if (body.getProductId() == data.get(i).getProductId()) {
				return null;
			}
		}
		data.add(body);
		return body;
	}

	@GetMapping("/product/{productId}")
	public Product getProductDetail(@PathVariable Integer productId) {
		System.out.println(" Product =" + productId);
		for (int i = 0; i < data.size(); i++) {
			if (productId == data.get(i).getProductId()) {
				return data.get(i);
			}
		}
		return null;
	}

	@PutMapping("/product/{productId}")
	public Product updatedProduct(@PathVariable Integer productId, @RequestBody Product body) {
		for (int i = 0; i < data.size(); i++) {
			if (productId == data.get(i).getProductId()) {
				data.get(i).setProductName(body.getProductName());
				data.get(i).setProductPrice(body.getProductPrice());
				data.get(i).setProductAmount(body.getProductAmount());
				data.get(i).setProductDetail(body.getProductDetail());

				return data.get(i);
			}
		}
		return null;
	}

	@DeleteMapping("product/{productId}")
	public String deleteProduct(@PathVariable Integer productId) {

		for (int i = 0; i < data.size(); i++) {
			if (productId == data.get(i).getProductId()) {
				data.remove(i);
				return "delete sucsess";

			}
		}
		return " not found";

	}

	@GetMapping("/search")
	public List<Product> searchProduct(@RequestParam String searchName, @RequestParam String searchDetail) {

		List<Product> searchResults = new ArrayList<Product>();

		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getProductName().contains(searchName) && searchName != ""
					|| data.get(i).getProductDetail().contains(searchDetail) && searchDetail != "") {

				searchResults.add(data.get(i));
			}
		}
		return searchResults;
	}
}

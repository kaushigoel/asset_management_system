package com.asset.management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.asset.management.entity.Asset;
import com.asset.management.entity.Category;

/**
 * @author KaushikiGoel
 * 
 *
 */
public interface AssetControllerInterface {

	@GetMapping("/categories")
	public List<Category> getAllCategories();

	@PutMapping("/updateCategory/{cat_id}")
	public Category updateOneCategory(@RequestBody Category cat, @PathVariable("cat_id") String cat_id);

	@PostMapping("/addCategory")
	public Category addOneCategory(@RequestBody Category cat);

	@PostMapping("/addAsset")
	public Asset addOneAsset(@RequestBody Asset asset);

	@GetMapping("/assets")
	public List<Asset> getAllAssets();

	@GetMapping("/asset/{name}")
	public Asset getAssetByName(@PathVariable("name") String name);

	@PutMapping("/updateAsset/{name}")
	public Asset updateOneAsset(@RequestBody Asset asset, @PathVariable("name") String name);

	@DeleteMapping("/asset/{name}")
	public void deleteOneAsset(@PathVariable("name") String name);
}

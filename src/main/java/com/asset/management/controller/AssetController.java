package com.asset.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asset.management.Service.AssetServiceInterface;
import com.asset.management.entity.Asset;
import com.asset.management.entity.Category;

@RestController
public class AssetController implements AssetControllerInterface {

	@Autowired
	private AssetServiceInterface assetServiceInterface;

	// getting all categories
	public List<Category> getAllCategories() {
		return this.assetServiceInterface.findAllCategories();
	}

	// updating a category
	public Category updateOneCategory(Category cat, String id) {
		return this.assetServiceInterface.updateOneCategory(cat, Integer.parseInt(id));
	}

	// adding new category
	public Category addOneCategory(Category cat) {
		return this.assetServiceInterface.addCategory(cat);
	}

	// adding new asset
	public Asset addOneAsset(Asset asset) {
		return this.assetServiceInterface.addAsset(asset);
	}

	// getting all assets
	public List<Asset> getAllAssets() {
		return this.assetServiceInterface.getAssets();
	}

	// getting asset by name
	public Asset getAssetByName(String name) {
		return this.assetServiceInterface.searchAssetByName(name);
	}

	// updating one asset
	public Asset updateOneAsset(Asset asset, String name) {
		return this.assetServiceInterface.updateAsset(asset, name);
	}

	// deleting one asset
	public void deleteOneAsset(String name) {
		this.assetServiceInterface.deleteAsset(name);
	}

}

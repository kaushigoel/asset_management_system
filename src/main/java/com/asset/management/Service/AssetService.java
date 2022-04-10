package com.asset.management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asset.management.Repository.AssetRepository;
import com.asset.management.Repository.CategoryRepository;
import com.asset.management.entity.Asset;
import com.asset.management.entity.Category;

@Service
public class AssetService implements AssetServiceInterface {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private AssetRepository assetRepository;

	// list of all categories
	public List<Category> findAllCategories() {
		return this.categoryRepository.findAll();
	}

	// update a category
	public Category updateOneCategory(Category cat, int id) {
		return this.categoryRepository.save(cat);
	}

	// add a category
	public Category addCategory(Category cat) {
		return this.categoryRepository.save(cat);
	}

	// add a asset
	public Asset addAsset(Asset asset) {
		return this.assetRepository.save(asset);
	}

	// getting list of assets
	public List<Asset> getAssets() {
		return this.assetRepository.findAll();
	}

	// getting asset by name
	public Asset searchAssetByName(String name) {
		return this.assetRepository.findById(name).get();
	}

	// updating a asset
	public Asset updateAsset(Asset newasset, String name) {
		return this.assetRepository.save(newasset);

	}

	// deleting a asset
	public void deleteAsset(String name) {
		Asset as = assetRepository.findById(name).get();
		if (as.getStatus().equals("Assigned"))
			return;
		else {
			this.assetRepository.delete(as);

		}

	}
}

package com.asset.management.Service;

import java.util.List;

import com.asset.management.entity.Asset;
import com.asset.management.entity.Category;

public interface AssetServiceInterface {

	public List<Category> findAllCategories();

	public Category addCategory(Category cat);

	public Category updateOneCategory(Category cat, int id);

	public Asset addAsset(Asset asset);

	public List<Asset> getAssets();

	public Asset searchAssetByName(String name);

	public Asset updateAsset(Asset asset, String name);

	public void deleteAsset(String name);
}

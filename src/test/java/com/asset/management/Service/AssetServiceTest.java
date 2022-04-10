package com.asset.management.Service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.asset.management.Repository.AssetRepository;
import com.asset.management.Repository.CategoryRepository;
import com.asset.management.entity.Asset;
import com.asset.management.entity.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
class AssetServiceTest {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private AssetRepository assetRepository;
	@Autowired
	private AssetService assetService;

	@Test
	void testFindAllCategories() {
		when(categoryRepository.findAll())
				.thenReturn(Stream.of(new Category(12, "Stationary items", "This contain stationary items"))
						.collect(Collectors.toList()));
		assertEquals(1, assetService.findAllCategories().size());

	}

	@Test
	void testUpdateOneCategory() {
		Category c1 = new Category("electronics", "this contain electrical items");
		categoryRepository.save(c1);
		Category c2 = new Category(1, "furnitures", "this contain furnitures");
		assetService.updateOneCategory(c2, 1);
		Category c = categoryRepository.findById(1).get();
		assertEquals(1, c.getCat_id());
		assertEquals("furnitures", c.getCat_name());
		assertEquals("this contain furnitures", c.getCat_description());

	}

	@Test
	void testAddCategory() {
		Category c = new Category();
		c.setCat_id(1);
		c.setCat_name("electronics");
		c.setCat_description("this contain electronical items");
		assetService.addCategory(c);
		assertNotNull(categoryRepository.findById(1));

	}

	@Test
	void testAddAsset() {
		Asset a = new Asset("ThinkPad", "20-04-2020", "condition notes1", "Laptop", "Available");

		assetService.addAsset(a);
		assertNotNull(assetRepository.findById("ThinkPad"));
	}

	@Test
	void testGetAssets() {
		when(assetRepository.findAll())
				.thenReturn(Stream.of(new Asset("ThinkPad", "20-04-2020", "condition notes1", "Laptop", "Available"))
						.collect(Collectors.toList()));
		assertEquals(1, assetService.getAssets().size());
	}

	@Test
	void testSearchAssetByName() {
		Asset a = new Asset("ThinkPad", "20-04-2020", "condition notes1", "Laptop", "Available");
		assetRepository.save(a);

		Asset actual = assetService.searchAssetByName("ThinkPad");
		assertEquals("ThinkPad", actual.getName());
		assertEquals("20-04-2020", actual.getPurchase_date());
		assertEquals("condition notes1", actual.getCondition_notes());
		assertEquals("Laptop", actual.getCategory());
		assertEquals("Available", actual.getStatus());
	}

	@Test
	void testUpdateAsset() {
		Asset a = new Asset("ThinkPad", "20-04-2020", "condition notes1", "Laptop", "Available");
		assetRepository.save(a);

		Asset up = new Asset("ThinkPad", "19-04-2020", "condition notes2", "Electronics", "Recovered");
		assetService.updateAsset(up, "ThinkPad");

		Asset as = assetRepository.findById("ThinkPad").get();
		assertEquals("19-04-2020", as.getPurchase_date());
		assertEquals("condition notes2", as.getCondition_notes());
		assertEquals("Electronics", as.getCategory());
		assertEquals("Recovered", as.getStatus());

	}

	@Test
	void testDeleteAsset() {
		Asset a1 = new Asset("ThinkPad", "20-04-2020", "condition notes1", "Laptop", "Available");
		assetRepository.save(a1);
		Asset a2 = new Asset("Dell", "20-04-2020", "condition notes2", "Laptop", "Available");
		assetRepository.save(a2);

		assetService.deleteAsset("Dell");
		List<Asset> list = assetRepository.findAll();
		assertTrue(list.size() == 1);

	}

}

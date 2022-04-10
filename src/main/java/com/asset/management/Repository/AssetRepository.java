package com.asset.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asset.management.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String> {

}

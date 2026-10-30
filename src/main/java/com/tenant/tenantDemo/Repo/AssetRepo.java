package com.tenant.tenantDemo.Repo;

import com.tenant.tenantDemo.Entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepo extends JpaRepository<Asset,Integer> {



    List<Asset> findAssetsByAssetName(String assetName);
}

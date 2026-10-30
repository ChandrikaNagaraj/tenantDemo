package com.tenant.tenantDemo.Service;

import com.tenant.tenantDemo.Entity.Asset;
import com.tenant.tenantDemo.Exception.MoreThanOneRecordException;
import com.tenant.tenantDemo.Exception.RecordNotFoundException;
import com.tenant.tenantDemo.Repo.AssetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {

    @Autowired
    private AssetRepo assetRepo;

    public void saveAsset(Asset asset) {
        assetRepo.save(asset);
    }

    public List<Asset> getAllAssets() {
        return assetRepo.findAll();
    }

    public String deleteAsset(String assetName) throws MoreThanOneRecordException {
        List<Asset> assetList = assetRepo.findAssetsByAssetName(assetName);
        if (assetList.size() == 1) {
            assetRepo.delete(assetList.getFirst());
        } else {
            throw new MoreThanOneRecordException("Cannot Delete !. No Record or more than one record exists");
        }
        return assetName;
    }

    public Asset getAssetById(int assetId) throws RecordNotFoundException {
        Optional<Asset> assset = assetRepo.findById(assetId);
        if (assset.isPresent()) {
            return assset.get();
        } else {
            throw new RecordNotFoundException("No Record Found Plz verify");
        }
    }

    public Asset update(Asset asst) throws RecordNotFoundException {
        Optional<Asset> oldAsset = assetRepo.findById(asst.getAssetId());

        if (oldAsset.isPresent()) {
            Asset ast = oldAsset.get();
            ast.setAssetName(asst.getAssetName());
            ast.setAssetLocation(asst.getAssetLocation());
            ast.setAssetPin(asst.getAssetPin());
            ast.setAssetContacts(ast.getAssetContacts());
            assetRepo.save(ast);
            return ast;
        } else {
            throw new RecordNotFoundException("No Record Found for the asset with asset id:- " + asst.getAssetId());
        }
    }


}

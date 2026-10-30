package com.tenant.tenantDemo.Controller;


import com.tenant.tenantDemo.Entity.Asset;
import com.tenant.tenantDemo.Exception.MoreThanOneRecordException;
import com.tenant.tenantDemo.Exception.RecordNotFoundException;
import com.tenant.tenantDemo.Service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping("/addAsset")
    public void addAsset(@RequestBody Asset asset) {
        assetService.saveAsset(asset);
    }

    @GetMapping("/assets")
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    @DeleteMapping("/deleteAsset/{assetname}")
    public String deleteAsset(@PathVariable("assetname") String asset) throws MoreThanOneRecordException {
        return assetService.deleteAsset(asset);
    }

    @GetMapping("/getAsset/{assetid}")
    public Asset getAsset(@PathVariable("assetid") int assetId) throws RecordNotFoundException {
        return assetService.getAssetById(assetId);
    }

    @PutMapping("/updateAsset")
    public Asset upDateAsset(@RequestBody Asset asset) throws RecordNotFoundException {
        return assetService.update(asset);
    }

}

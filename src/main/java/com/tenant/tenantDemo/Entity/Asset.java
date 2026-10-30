package com.tenant.tenantDemo.Entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "assetmast")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assetid")
    private Integer assetId;

    @Column(name = "assetname", length = 45)
    private String assetName;

    @Column(name = "assetlocation", length = 45)
    private String assetLocation;

    @Column(name = "assetpin", length = 45)
    private String assetPin;

    @Column(name = "assetcontacts", length = 3000)
    private String assetContacts;

    @CreationTimestamp
    private LocalDateTime createddate;

    public LocalDateTime getCreateddate() {
        return createddate;
    }

    public void setCreateddate(LocalDateTime createddate) {
        this.createddate = createddate;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetLocation() {
        return assetLocation;
    }

    public void setAssetLocation(String assetLocation) {
        this.assetLocation = assetLocation;
    }

    public String getAssetPin() {
        return assetPin;
    }

    public void setAssetPin(String assetPin) {
        this.assetPin = assetPin;
    }

    public String getAssetContacts() {
        return assetContacts;
    }

    public void setAssetContacts(String assetContacts) {
        this.assetContacts = assetContacts;
    }


}

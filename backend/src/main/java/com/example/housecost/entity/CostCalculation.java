package com.example.housecost.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
public class CostCalculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal landArea;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal buildingArea;

    @Column(nullable = false)
    private Integer floors;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal constructionCostPerSqm;

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal permitRate;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal utilityFee;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal inspectionFee;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal baseConstructionCost;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal permitFee;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal totalCost;

    @Column(nullable = false)
    private Instant createdAt = Instant.now();

    public Long getId() {
        return id;
    }

    public BigDecimal getLandArea() {
        return landArea;
    }

    public void setLandArea(BigDecimal landArea) {
        this.landArea = landArea;
    }

    public BigDecimal getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(BigDecimal buildingArea) {
        this.buildingArea = buildingArea;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public BigDecimal getConstructionCostPerSqm() {
        return constructionCostPerSqm;
    }

    public void setConstructionCostPerSqm(BigDecimal constructionCostPerSqm) {
        this.constructionCostPerSqm = constructionCostPerSqm;
    }

    public BigDecimal getPermitRate() {
        return permitRate;
    }

    public void setPermitRate(BigDecimal permitRate) {
        this.permitRate = permitRate;
    }

    public BigDecimal getUtilityFee() {
        return utilityFee;
    }

    public void setUtilityFee(BigDecimal utilityFee) {
        this.utilityFee = utilityFee;
    }

    public BigDecimal getInspectionFee() {
        return inspectionFee;
    }

    public void setInspectionFee(BigDecimal inspectionFee) {
        this.inspectionFee = inspectionFee;
    }

    public BigDecimal getBaseConstructionCost() {
        return baseConstructionCost;
    }

    public void setBaseConstructionCost(BigDecimal baseConstructionCost) {
        this.baseConstructionCost = baseConstructionCost;
    }

    public BigDecimal getPermitFee() {
        return permitFee;
    }

    public void setPermitFee(BigDecimal permitFee) {
        this.permitFee = permitFee;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}


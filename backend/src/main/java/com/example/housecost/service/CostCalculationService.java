package com.example.housecost.service;

import com.example.housecost.dto.CostCalculationRequest;
import com.example.housecost.dto.CostCalculationResponse;
import com.example.housecost.entity.CostCalculation;
import com.example.housecost.repository.CostCalculationRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

@Service
public class CostCalculationService {
    private final CostCalculationRepository repository;

    public CostCalculationService(CostCalculationRepository repository) {
        this.repository = repository;
    }

    public CostCalculationResponse calculateAndSave(CostCalculationRequest request) {
        BigDecimal baseConstructionCost = request.buildingArea()
                .multiply(request.constructionCostPerSqm())
                .multiply(BigDecimal.valueOf(request.floors()))
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal permitFee = baseConstructionCost
                .multiply(request.permitRate())
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal totalCost = baseConstructionCost
                .add(permitFee)
                .add(request.utilityFee())
                .add(request.inspectionFee())
                .setScale(2, RoundingMode.HALF_UP);

        CostCalculation calculation = new CostCalculation();
        calculation.setLandArea(request.landArea());
        calculation.setBuildingArea(request.buildingArea());
        calculation.setFloors(request.floors());
        calculation.setConstructionCostPerSqm(request.constructionCostPerSqm());
        calculation.setPermitRate(request.permitRate());
        calculation.setUtilityFee(request.utilityFee());
        calculation.setInspectionFee(request.inspectionFee());
        calculation.setBaseConstructionCost(baseConstructionCost);
        calculation.setPermitFee(permitFee);
        calculation.setTotalCost(totalCost);

        CostCalculation saved = repository.save(calculation);

        return new CostCalculationResponse(
                saved.getId(),
                saved.getBaseConstructionCost(),
                saved.getPermitFee(),
                saved.getUtilityFee(),
                saved.getInspectionFee(),
                saved.getTotalCost()
        );
    }
}


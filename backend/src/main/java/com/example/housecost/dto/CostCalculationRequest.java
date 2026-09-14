package com.example.housecost.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record CostCalculationRequest(
        @NotNull @Min(1) BigDecimal landArea,
        @NotNull @Min(1) BigDecimal buildingArea,
        @NotNull @Min(1) Integer floors,
        @NotNull @Min(1) BigDecimal constructionCostPerSqm,
        @NotNull @Min(0) BigDecimal permitRate,
        @NotNull @Min(0) BigDecimal utilityFee,
        @NotNull @Min(0) BigDecimal inspectionFee
) {
}


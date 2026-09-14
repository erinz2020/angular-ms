package com.example.housecost.dto;

import java.math.BigDecimal;

public record CostCalculationResponse(
        Long id,
        BigDecimal baseConstructionCost,
        BigDecimal permitFee,
        BigDecimal utilityFee,
        BigDecimal inspectionFee,
        BigDecimal totalCost
) {
}


package com.example.housecost.controller;

import com.example.housecost.dto.CostCalculationRequest;
import com.example.housecost.dto.CostCalculationResponse;
import com.example.housecost.service.CostCalculationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/costs")
public class CostCalculationController {
    private final CostCalculationService costCalculationService;

    public CostCalculationController(CostCalculationService costCalculationService) {
        this.costCalculationService = costCalculationService;
    }

    @PostMapping("/calculate")
    public CostCalculationResponse calculate(@Valid @RequestBody CostCalculationRequest request) {
        return costCalculationService.calculateAndSave(request);
    }
}


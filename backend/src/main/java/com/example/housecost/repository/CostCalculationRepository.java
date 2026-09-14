package com.example.housecost.repository;

import com.example.housecost.entity.CostCalculation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostCalculationRepository extends JpaRepository<CostCalculation, Long> {
}


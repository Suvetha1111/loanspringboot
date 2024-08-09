
package com.icanio.quest_financial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@Entity
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double fixedDeposit;
    private double stockTrading;
    private double mutualFunds;
    private double depositPlan;
    private double hybridFunds;
    private LocalDate startingDate;
    private LocalDate lastUpdateDate;
    // Getters and Setters
}

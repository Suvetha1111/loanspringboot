package com.icanio.quest_financial.model;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Setter
@Getter
@Entity

public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double personalLoan;
    private double businessLoan;
    private double doctorLoan;
    private double goldLoan;
    private double homeLoan;
    private double twoWheelerLoan;
    private String offers;
    private LocalDate startingDate;
    private LocalDate lastUpdateDate;

    // Getters and Setters
}

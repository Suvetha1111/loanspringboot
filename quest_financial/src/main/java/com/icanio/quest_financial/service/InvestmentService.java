package com.icanio.quest_financial.service;

import com.icanio.quest_financial.model.Investment;
import com.icanio.quest_financial.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentService {
    @Autowired
    private InvestmentRepository investmentRepository;

    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    public Optional<Investment> getInvestmentById(Long id) {
        return investmentRepository.findById(id);
    }

    public Investment saveInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    public Investment updateInvestment(Long id, Investment investmentDetails) {
        Investment investment = investmentRepository.findById(id).orElseThrow();
        investment.setFixedDeposit(investmentDetails.getFixedDeposit());
        investment.setStockTrading(investmentDetails.getStockTrading());
        investment.setMutualFunds(investmentDetails.getMutualFunds());
        investment.setDepositPlan(investmentDetails.getDepositPlan());
        investment.setHybridFunds(investmentDetails.getHybridFunds());
        investment.setStartingDate(investmentDetails.getStartingDate());
        investment.setLastUpdateDate(investmentDetails.getLastUpdateDate());
        return investmentRepository.save(investment);
    }

    public void deleteInvestment(Long id) {
        investmentRepository.deleteById(id);
    }
}


package com.icanio.quest_financial.service;

import com.icanio.quest_financial.model.Loans;
import com.icanio.quest_financial.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoansService {
    @Autowired
    private LoansRepository loansRepository;

    public List<Loans> getAllLoans() {
        return loansRepository.findAll();
    }

    public Optional<Loans> getLoansById(Long id) {
        return loansRepository.findById(id);
    }

    public Loans saveLoans(Loans loans) {
        return loansRepository.save(loans);
    }

    public Loans updateLoans(Long id, Loans loansDetails) {
        Loans loans = loansRepository.findById(id).orElseThrow();
        loans.setPersonalLoan(loansDetails.getPersonalLoan());
        loans.setBusinessLoan(loansDetails.getBusinessLoan());
        loans.setDoctorLoan(loansDetails.getDoctorLoan());
        loans.setGoldLoan(loansDetails.getGoldLoan());
        loans.setHomeLoan(loansDetails.getHomeLoan());
        loans.setTwoWheelerLoan(loansDetails.getTwoWheelerLoan());
        loans.setOffers(loansDetails.getOffers());
        loans.setStartingDate(loansDetails.getStartingDate());
        loans.setLastUpdateDate(loansDetails.getLastUpdateDate());
        return loansRepository.save(loans);
    }

    public void deleteLoans(Long id) {
        loansRepository.deleteById(id);
    }
}


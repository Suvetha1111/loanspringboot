package com.icanio.quest_financial.controller;

import com.icanio.quest_financial.model.Loans;
import com.icanio.quest_financial.service.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
public class LoansController {
    @Autowired
    private LoansService loansService;

    @GetMapping
    public List<Loans> getAllLoans() {
        return loansService.getAllLoans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loans> getLoansById(@PathVariable Long id) {
        Optional<Loans> loans = loansService.getLoansById(id);
        return loans.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Loans createLoans(@RequestBody Loans loans) {
        return loansService.saveLoans(loans);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loans> updateLoans(@PathVariable Long id, @RequestBody Loans loansDetails) {
        return ResponseEntity.ok(loansService.updateLoans(id, loansDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoans(@PathVariable Long id) {
        loansService.deleteLoans(id);
        return ResponseEntity.noContent().build();
    }
}


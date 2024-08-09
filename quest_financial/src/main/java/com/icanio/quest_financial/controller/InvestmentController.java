package com.icanio.quest_financial.controller;

import com.icanio.quest_financial.model.Investment;
import com.icanio.quest_financial.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {
    @Autowired
    private InvestmentService investmentService;

    @GetMapping
    public List<Investment> getAllInvestments() {
        return investmentService.getAllInvestments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investment> getInvestmentById(@PathVariable Long id) {
        Optional<Investment> investment = investmentService.getInvestmentById(id);
        return investment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Investment createInvestment(@RequestBody Investment investment) {
        return investmentService.saveInvestment(investment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investment> updateInvestment(@PathVariable Long id, @RequestBody Investment investmentDetails) {
        return ResponseEntity.ok(investmentService.updateInvestment(id, investmentDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestment(@PathVariable Long id) {
        investmentService.deleteInvestment(id);
        return ResponseEntity.noContent().build();
    }
}


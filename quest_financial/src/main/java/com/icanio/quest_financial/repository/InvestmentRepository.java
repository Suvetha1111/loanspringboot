package com.icanio.quest_financial.repository;

import com.icanio.quest_financial.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
}


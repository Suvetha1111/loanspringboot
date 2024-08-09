package com.icanio.quest_financial.repository;

import com.icanio.quest_financial.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoansRepository extends JpaRepository<Loans, Long> {
}


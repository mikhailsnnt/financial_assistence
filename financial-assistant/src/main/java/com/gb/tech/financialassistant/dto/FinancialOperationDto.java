package com.gb.tech.financialassistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialOperationDto {

    private Long id;
    private Long account;
    private Long operationCategory;
    private Boolean isSpending;
    private BigDecimal amount;
    private LocalDateTime dateTime;
}

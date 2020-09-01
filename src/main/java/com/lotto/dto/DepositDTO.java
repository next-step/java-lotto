package com.lotto.dto;

import com.lotto.domain.Deposit;

public class DepositDTO {

    int amount;
    int manual;

    public DepositDTO(int amount, int manual) {
        this.amount = amount;
        this.manual = manual;
    }

    public Deposit of() {
        return new Deposit(amount, manual);
    }
}

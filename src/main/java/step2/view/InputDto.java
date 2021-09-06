package step2.view;

import step2.domain.statistics.Amount;

public class InputDto {
    private final Amount amount;

    public InputDto(Amount amount) {
        this.amount = amount;
    }

    public Amount getAmount() {
        return this.amount;
    }
}

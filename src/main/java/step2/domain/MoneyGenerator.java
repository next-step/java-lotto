package step2.domain;

import step2.dto.MoneyDTO;

public class MoneyGenerator {
    public MoneyDTO generateMoney(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
        return new MoneyDTO(amount);
    }
}

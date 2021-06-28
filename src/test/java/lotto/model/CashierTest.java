package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashierTest {
    private Cashier cashier;

    @BeforeEach
    void setUp() {
        cashier = new Cashier(5000);
    }

    @DisplayName(value = "로또 수량 계산하기")
    @Test
    void calculate_lotto_quantity() {
        assertThat(cashier.calculateLottoQuantity()).isEqualTo(5);
    }
}

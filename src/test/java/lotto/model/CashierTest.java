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
        assertThat(cashier.getLottoQuantity()).isEqualTo(5);
    }

    @DisplayName(value = "자동, 수동 로또 수량 계산하기")
    @Test
    void calculate_auto_lotto_quantity() {
        cashier.calculateAutoLottoQuantity(3);
        assertThat(cashier.getAutoQuantity()).isEqualTo(2);
        assertThat(cashier.getManualQuantity()).isEqualTo(3);
    }
}

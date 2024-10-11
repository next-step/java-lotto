package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashierTest {
    private Cashier cashier;

    @BeforeEach
    void setUp() {
        cashier = new Cashier();
    }

    @Test
    @DisplayName("금액에 따른 로또 갯수를 확인")
    void 로또_발행_장수() {
        int totalAmount = 14000;
        assertThat(cashier.makeLottoGamePapers(totalAmount)).isEqualTo(14);
    }
}

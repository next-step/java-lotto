package lotto.oop.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {
    private Amount amount;

    @Test
    @DisplayName("구입금액 확인 1000원 단위")
    void moneyConfirm() {
        assertThatThrownBy(() -> {
            new Amount(100);
        }).isInstanceOf(ArithmeticException.class);

    }
}

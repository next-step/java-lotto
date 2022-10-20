package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseMoneyTest {

    @DisplayName("구입 금액이 1000원 이하일 때 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 999, -1000})
    void purchaseMoneyMinimumTest(int input) {
        assertThatThrownBy(() -> new PurchaseMoney(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

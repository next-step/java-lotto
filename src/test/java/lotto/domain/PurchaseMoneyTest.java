package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseMoneyTest {

    @DisplayName("구입 금액이 1000원 이하일 때 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 999, -1000})
    void purchaseMoneyMinimumTest(int input) {
        assertThatThrownBy(() -> new PurchaseMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

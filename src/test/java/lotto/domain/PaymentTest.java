package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PaymentTest {

    @ParameterizedTest
    @DisplayName("생성자 금액 검증 - 최소금액(천원), 최대 금액(십만원)")
    @ValueSource(ints = {500, 100500})
    void checkAmountRange(int amount) {
        assertThatThrownBy(() -> new Payment(amount, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 금액을 조회한다.")
    void checkAmount() {
        assertThat(new Payment(10000, 0).amount())
                .isEqualTo(10000);
    }

    @Test
    @DisplayName("입력된 구매 가능 수량을 조회 한다.")
    void checkCount() {
        assertThat(new Payment(10000, 0).automaticCount())
                .isEqualTo(10);
    }
}

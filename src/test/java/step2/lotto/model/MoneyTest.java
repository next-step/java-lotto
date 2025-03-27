package step2.lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.exception.MoneyException;

public class MoneyTest {

    @Test
    @DisplayName("올바른 구입 금액 입력")
    void givenCorrectPurchaseAmount_whenCreateMoney_thenSuccess() {
        // given
        String purchaseAmount = "1000";

        // when
        Money money = new Money(purchaseAmount);

        // then
        assertThat(money.value()).isEqualTo(1000);
    }

    @Test
    @DisplayName("정수가 아닌 구입 금액 입력")
    void givenNotIntegerPurchaseAmount_whenCreateMoney_thenThrowException() {
        // given
        String purchaseAmount = "abc";

        // when
        assertThatThrownBy(() -> new Money(purchaseAmount))

            // then
            .isExactlyInstanceOf(MoneyException.class);
    }

    @Test
    @DisplayName("음수 구입 금액 입력")
    void givenNegativePurchaseAmount_whenCreateMoney_thenThrowException() {
        // given
        String purchaseAmount = "-1000";

        // when
        assertThatThrownBy(() -> new Money(purchaseAmount))

            // then
            .isExactlyInstanceOf(MoneyException.class);
    }

}

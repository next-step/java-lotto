package lotto;

import lotto.utils.ValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationLottoTest {

    @DisplayName("구매 금액이 1000원 미만일때 Exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"999"})
    void isPurchaseAmount(String money) {
        // GIVE
        // WHEN
        // THEN
        assertThatThrownBy(() -> ValidationUtil.isPurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 Null 일때 Exception 발생")
    @Test
    void isNumber() {
        // GIVE
        String money = null;
        // WHEN
        // THEN
        assertThatThrownBy(() -> ValidationUtil.isNumber(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 음수 일때 Exception 발생")
    @Test
    void isNegativeNum() {
        // GIVE
        // WHEN
        // THEN
        assertThatThrownBy(() -> ValidationUtil.isNegativeNum("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

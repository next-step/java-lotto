package lotto;

import lotto.utils.ValidationUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationLottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"999"})
    void isPurchaseAmount(String money) {
        // GIVE
        // WHEN
        // THEN
        assertThatThrownBy(() -> ValidationUtil.isPurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNumber() {
        // GIVE
        String money = null;
        // WHEN
        // THEN
        assertThatThrownBy(() -> ValidationUtil.isNumber(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNegativeNum() {
        // GIVE
        // WHEN
        // THEN
        assertThatThrownBy(() -> ValidationUtil.isNegativeNum("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

package lotto;

import lotto.utils.ValidationLotto;
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
        assertThatThrownBy(() -> ValidationLotto.isPurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNumber() {
        // GIVE
        String money = null;
        // WHEN
        // THEN
        assertThatThrownBy(() -> ValidationLotto.isNumber(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNegativeNum() {
        // GIVE
        // WHEN
        // THEN
        assertThatThrownBy(() -> ValidationLotto.isNegativeNum("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

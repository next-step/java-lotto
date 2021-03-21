package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationLottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"999"})
    void isPurchaseAmount(String money) {
        // GIVE
        boolean result = ValidationLotto.isPurchaseAmount(money);
        // WHEN
        // THEN
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"DD"})
    void isNumber(String money) {
        // GIVE
        // WHEN
        // THEN
        assertThatThrownBy(() -> ValidationLotto.isNumber(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoNumCheck() {
        // GIVE
        // WHEN
        // THEN
        assertThatThrownBy(() -> new Number(47))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoNumCheck() {
        // GIVE
        // WHEN
        // THEN
        assertThatThrownBy(() -> ValidationLotto.isNegativeNum(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

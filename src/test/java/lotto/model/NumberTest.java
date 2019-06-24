package lotto.model;

import lotto.exception.InvalidNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.Number.MAX;
import static lotto.model.Number.MIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NumberTest {

    @DisplayName("숫자를 생성하는데 성공한다")
    @Test
    void createNumberSuccess() {
        assertThat(Number.of(1)).isEqualTo(Number.of(1));
    }

    @DisplayName("숫자가 " + MIN + "보다 작을 때 실패한다")
    @Test
    void createMinLessThanBallThenFail() {
        assertThatExceptionOfType(InvalidNumberException.class)
                .isThrownBy(() -> Number.of(MIN - 1));
    }

    @DisplayName("숫자가 " + MAX + "보다 큰 경우 실패한다")
    @Test
    void createMaxGreaterThanBallThenFail() {
        assertThatExceptionOfType(InvalidNumberException.class)
                .isThrownBy(() -> Number.of(MAX + 1));
    }
}

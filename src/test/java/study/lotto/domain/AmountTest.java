package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.exception.IllegalNumberRangeArgumentException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AmountTest {
    @DisplayName("숫자를 입력할 수 있다.")
    @Test
    void allowNumber() {
        int testVal = 1;
        Amount amount = new Amount(testVal);
        assertThat(amount.getValue()).isEqualTo(testVal);
        assertThat(amount).isEqualTo(new Amount(testVal));
    }

    @DisplayName("음수를 입력할 수 없다.")
    @Test
    void disallowNegative() {
        assertThatExceptionOfType(IllegalNumberRangeArgumentException.class)
                .isThrownBy(() -> new Amount(-1));
    }
}

package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {
    @Test
    void shouldThrowWhenInputNotSixNumbers() {
        assertThatThrownBy(() -> LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 6자리여야 합니다.");
    }
}
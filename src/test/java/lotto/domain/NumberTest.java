package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 50})
    void 유효숫자_예외(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Number(input);
                });
    }
}

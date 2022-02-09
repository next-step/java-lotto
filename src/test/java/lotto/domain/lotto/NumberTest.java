package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @DisplayName("숫자가 주어졌을 때, 유효범위를 벗어나면 예외 출력")
    @ParameterizedTest
    @ValueSource(ints = {-1,100})
    void testNumberInvalid(final int number) {
        assertThatThrownBy(() -> new Number(number))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

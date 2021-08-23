package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 47})
    @DisplayName("입력된 숫자가 범위를 초과한 경우 Exception 발생한다.")
    void input_count_not_six_exception_test(int number) {
        assertThatThrownBy(() ->
                new Number(number)
        ).isInstanceOf(IllegalArgumentException.class);

    }
}

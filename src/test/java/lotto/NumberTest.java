package lotto;

import lotto.domain.Number;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumberTest {
    @ParameterizedTest(name = "입력 숫자가 {0}일 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 46})
    void create(int number) {
        assertThatThrownBy(() -> {
            new Number(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

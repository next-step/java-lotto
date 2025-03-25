package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumberTest {
    @ParameterizedTest(name = "로또 번호의 범위를 넘어선 값으로 생성할 경우 예외를 던진다. 입력값: {0}")
    @ValueSource(ints = {0, 46})
    void invalidNumberTest(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

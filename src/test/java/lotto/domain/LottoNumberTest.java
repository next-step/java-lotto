package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @ParameterizedTest(name = "범위 내의 숫자로 로또 숫자 생성: {0}")
    @ValueSource(ints = {1, 20, 45})
    void create(int number) {
        assertThat(new LottoNumber(number)).isEqualTo(new LottoNumber(number));
    }

    @ParameterizedTest(name = "범위 밖의 숫자로 로또 숫자 생성(예외): {0}")
    @ValueSource(ints = {-1, 0, 46, 47})
    void testWithInvalidInput(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 번호 범위 밖의 숫자의 입력입니다");
    }
}

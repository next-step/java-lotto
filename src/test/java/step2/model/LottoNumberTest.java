package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("정적 생성자는 1 ~ 45까지 숫자 입력 가능")
    @ValueSource(ints = {1, 45})
    @ParameterizedTest
    void valueOf(int number) {
        LottoNumber lottoNumber = LottoNumber.valueOf(number);
        assertThat(lottoNumber).isInstanceOf(LottoNumber.class);
    }

    @DisplayName("정적 생성자는 입력 숫자가 1 ~ 45를 벗어나면 예외 발생")
    @ValueSource(ints = {0, 46})
    @ParameterizedTest
    void valueOfExceptionThrown(int number) {
        assertThatThrownBy(() -> LottoNumber.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("생성 성공")
    @ValueSource(ints = {1, 5, 10, 40, 45})
    void createSuccess(Integer number) {
        assertThat(LottoNumber.from(number)).isEqualTo(LottoNumber.from(number));
    }

    @ParameterizedTest
    @DisplayName("파라미터 null 예외처리")
    @NullSource
    void numberNullException(Integer number) {
        assertThatExceptionOfType(NullPointerException.class)
            .isThrownBy(() -> LottoNumber.from(number));
    }

    @ParameterizedTest
    @DisplayName("1~45 외의 숫자 입력 예외처리")
    @ValueSource(ints = {0, 46, 50})
    void numberBoundException(Integer number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoNumber.from(number));
    }

}

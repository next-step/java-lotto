package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.exception.NotNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ManualLottoNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38", "7, 11, 16, 35, 36, 44"})
    @DisplayName("생성 성공")
    void create(String input) {
        assertThat(new ManualLottoNumber(input).createLottoNumber().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"8, 21, 23, 41, 42, a", "3, 5, 11, 16, 32,a", "7, 11, 16, 35, 36,`"})
    @DisplayName("숫자 외에 값 예외처리")
    void createException(String input) {
        assertThatExceptionOfType(NotNumberException.class)
            .isThrownBy(() -> new ManualLottoNumber(input).createLottoNumber());
    }

}

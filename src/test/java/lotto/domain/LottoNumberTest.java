package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47, -1})
    @DisplayName("로또 번호가 1~45 이외의 값이 입력될 경우 예외발생")
    void validateNumber(int input) {
        assertThatThrownBy(()->LottoNumber.from(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("로또 번호는 1과 45사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45, 33, 7})
    @DisplayName("로또 번호가 1~45 내의 값이 입력될 경우 정상생성")
    void createNumber(int input) {
        LottoNumber lottoNumber = LottoNumber.from(input);

        assertThat(lottoNumber).isEqualTo(LottoNumber.from(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"@@", "$", "!", "A"})
    @DisplayName("숫자 형태가 아닌 문자열을 입력시 로또번호 객체 예외발생")
    void validateStringNumber(String input) {
        assertThatThrownBy(()-> LottoNumber.valueOf(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값은 로또번호로 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "45", "2"})
    @DisplayName("숫자 형태 문자열을 입력시 로또번호 객체 정상생성")
    void createStringNumber(String input) {
        LottoNumber lottoNumber = LottoNumber.valueOf(input);

        int number = lottoNumber.getValue();

        assertThat(number).isEqualTo(Integer.parseInt(input));
    }
}

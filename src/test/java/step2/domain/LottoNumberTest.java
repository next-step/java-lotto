package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {46, 47, 0, -2, 50})
    @DisplayName("옳지 않은 로또 번호를 인자로 받으면 예외를 던진다")
    public void notValidException(int input) {
        assertThatThrownBy(() -> {
            new LottoNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 45, 44, 30})
    @DisplayName("올바른 로또 번호를 인자로 받으면 정상적으로 객체가 생성된다")
    public void validNumber(int input) {
        assertThat(new LottoNumber(input)).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6: 1", "11, 13, 40, 41, 43, 45: 40", "10, 15, 30, 40, 43, 44: 30"}, delimiter = ':')
    @DisplayName("지난 당첨번호를 인자로 받아 포함되면 참을 리턴한다")
    public void matchedNumber(String input, int expected) {
        assertThat(new LottoNumber(expected).matchedWinningNumber(new MatchedNumber(input))).isTrue();
    }
}

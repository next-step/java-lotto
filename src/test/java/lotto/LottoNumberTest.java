package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("1보다 작거나 45보다 클때 예외처리")
    public void lottoNumber(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=1", "2=2"}, delimiter = '=')
    @DisplayName("로또 생성한 값과 number값 일치하는지 확인")
    public void of(String input, int expected) {
        assertThat(LottoNumber.of(input)).isEqualTo(LottoNumber.of(expected));
    }
}
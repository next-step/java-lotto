package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningLottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3"})
    void 유효숫자_예외(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new WinningLotto(input);
                });
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    void 당첨번호_포함(int input, boolean expected) {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");

        assertThat(winningLotto.contains(new Number(input)))
                .isEqualTo(expected);
    }
}

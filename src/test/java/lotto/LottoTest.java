package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("문자열을 컴마형태로 분리")
    public void ofComma() {
        Lotto lotto = Lotto.ofComma("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(Lotto.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("문자열 null시 예외처리")
    public void ofComma_문자열_isNull(String input) {
        assertThatThrownBy(() -> Lotto.ofComma(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("컴마로 분리한 객체와 타입이 일치하는지 확인한다.")
    public void of_Set() {
        HashSet lotto = new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(Lotto.of(lotto)).isEqualTo(Lotto.ofComma("1,2,3,4,5,6"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 5", "1, 2, 2, 4, 5, 6"})
    @DisplayName("로또넘버에 중복된 값이 있으면 예외 발생")
    public void ofComma_중복값(String input) {
        assertThatThrownBy(() -> Lotto.ofComma(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6=6"}, delimiter = '=')
    @DisplayName("로또와 당첨번호 갯수를 비교한다.")
    public void match(String input, int expected) {
        Lotto userLotto = Lotto.ofComma(input);
        Lotto winningLotto = Lotto.ofComma(input);
        assertThat(userLotto.match(winningLotto)).isEqualTo(expected);
    }
}
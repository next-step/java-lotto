package lotto.domain;

import lotto.StringParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @DisplayName("로또 번호 길이가 6이 아닌 경우 예외발생")
    @Test
    void whenLottoNumberSizeNotEqual6ThenException() {

        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
        );
    }

    @DisplayName("로또 번호에 1 ~ 45 사이가 아닌 수가 존재할 시 예외 발생")
    @Test
    void whenLottoNumberHasWrongNumberThenException() {

        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 46)))
        );
    }

    @DisplayName("당첨 번호 입력 시 일치하는 개수 반환")
    @ParameterizedTest
    @CsvSource(value = {"3, 4, 5, 6, 7, 8:4", "3,4,8,9,10,11:2"}, delimiterString = ":")
    void whenInputWinningNumbersThenReturnMatchCount(String input, int expected) {
        // given
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(StringParser.getParseNumbers(input));

        // when
        int matchCount = lotto.matchCount(winningNumbers);

        // then
        assertThat(matchCount).isEqualTo(expected);
    }
}

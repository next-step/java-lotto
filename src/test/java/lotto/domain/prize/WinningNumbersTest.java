package lotto.domain.prize;

import lotto.domain.lotto.LottoNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"})
    void 당첨번호_입력수_확인(String enteredWinNumber) {
        assertThatThrownBy(() -> new WinningNumbers(enteredWinNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_중복입력_확인() {
        String enteredWinNumber = "1, 1, 2, 3, 4, 5";

        assertThatThrownBy(() -> new WinningNumbers(enteredWinNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("중복된 당첨 번호가 있습니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"2, 3, 4, 5, 9, 19 | 0", "1, 7, 23, 32, 33, 34 | 4"
            , "1, 7, 23, 34, 37, 44 | 6"}, delimiter = '|')
    void 당첨번호_일치개수를_확인한다(String enteredWinNumber, int expectedCount) {
        WinningNumbers winningNumbers = new WinningNumbers(enteredWinNumber);
        LottoNumbers lottoNumbers = new LottoNumbers() {
            @Override
            protected List<Integer> createLottoNumbers() {
                return Arrays.asList(1, 7, 23, 34, 37, 44);
            }
        };
        int matchCount = winningNumbers.getMatchCount(lottoNumbers);

        assertThat(matchCount).isEqualTo(expectedCount);
    }
}
package lotto.domain.lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @ParameterizedTest
    @CsvSource(value = {"8, 21, 23, 41, 42, 43:0", "1, 3, 5, 14, 22, 45:3", "1, 3, 2, 4, 6, 5:6"}, delimiter = ':')
    @DisplayName("countOfMatch(): 로또 번호와 당첨 번호가 일치하는 번호의 개수를 반환한다.")
    void testCountOfMatch(String winningNumberInput, int expected) {
        WinningNumbers winningNumbers = WinningNumbers.valueOf(winningNumberInput);
        Lotto lotto = Lotto.valueOf(lottoNumbers);

        assertThat(lotto.countOfMatch(winningNumbers)).isEqualTo(expected);
    }
}

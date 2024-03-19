package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    LottoNumberGeneratingStrategy lottoNumberGeneratingStrategyStub = () -> Arrays.asList(1, 2, 3, 4, 5, 6);

    @ParameterizedTest
    @CsvSource(value = {"8, 21, 23, 41, 42, 43:0", "1, 3, 5, 14, 22, 45:3", "1, 3, 2, 4, 6, 5:6"}, delimiter = ':')
    void testNumberOfMatch(String winningNumberInput, int expected) {
        WinningNumbers winningNumbers = WinningNumbers.valueOf(winningNumberInput);
        Lotto lotto = Lotto.valueOf(lottoNumberGeneratingStrategyStub);

        assertThat(lotto.numberOfMatch(winningNumbers)).isEqualTo(expected);
    }
}

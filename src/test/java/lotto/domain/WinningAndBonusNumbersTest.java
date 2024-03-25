package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.TestUtil.numbersForTest;
import static org.assertj.core.api.Assertions.assertThat;

class WinningAndBonusNumbersTest {
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 10, 11, 12:20:FIFTH", "1, 2, 3, 4, 10, 11:20:FOURTH", "1, 2, 3, 4, 5, 10:20:THIRD", "1, 2, 3, 4, 5, 10:6:SECOND", "1, 2, 3, 4, 5, 6:20:FIRST"}, delimiter = ':')
    @DisplayName("rankOfLotto(): lotto에 맞는 Rank를 반환합니다. ")
    void testRankOfLotto(String winningNumbersInput, int bonusNumberInput, Rank expectedRank) {
        Lotto lotto = Lotto.valueOf(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList()));
        WinningNumbers winningNumbers = WinningNumbers.valueOf(numbersForTest(winningNumbersInput));
        BonusNumber bonusNumber = new BonusNumber(LottoNumber.valueOf(bonusNumberInput));

        WinningAndBonusNumbers winningAndBonusNumbers = WinningAndBonusNumbers.newWinningAndBonusNumbers(winningNumbers, bonusNumber);

        assertThat(winningAndBonusNumbers.rankOfLotto(lotto)).isEqualTo(expectedRank);
    }
}
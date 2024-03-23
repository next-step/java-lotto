package lotto.domain.lotto;

import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmountOfMoney;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.domain.lotto.strategy.LottoGeneratingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.view.InputView.COMMA_BLANK_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    LottoGeneratingStrategy lottoGeneratingStrategyStub = () -> {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        return Lotto.valueOf(lottoNumbers);
    };

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 7, 8, 9:10:FIFTH:5", "1, 2, 3, 4, 8, 9:10:FOURTH:50", "1, 2, 3, 4, 5, 9:10:THIRD:1500", "1, 2, 3, 4, 5, 9:6:SECOND:30000", "1, 2, 3, 4, 5, 6:10:FIRST:2000000"}, delimiter = ':')
    @DisplayName("statistics(): 로또의 결과(당첨 통계, 수익률)를 반환합니다.")
    void testStatistics(String winningNumbersInput, int bonusNumberInput, Rank rank, double expectedRateOfReturn) {
        PurchaseAmountOfMoney purchaseAmountOfMoney = PurchaseAmountOfMoney.valueOf(1000);
        Lottos lottos = LottoStore.purchaseLotto(lottoGeneratingStrategyStub, purchaseAmountOfMoney.numberOfLottoToPurchase());
        WinningNumbers winningNumbers = WinningNumbers.valueOf(lottoNumbersForTest(winningNumbersInput));
        BonusNumber bonusNumber = BonusNumber.newBonusNumberWithOutWinningNumbers(LottoNumber.valueOf(bonusNumberInput), winningNumbers);

        StatisticsOfLottos statisticsOfLottos = lottos.statistics(winningNumbers, bonusNumber, purchaseAmountOfMoney);

        assertThat(statisticsOfLottos.numberOfMatchCount(rank)).isEqualTo(1);
        assertThat(statisticsOfLottos.rateOfReturn()).isEqualTo(expectedRateOfReturn);
    }

    private Set<LottoNumber> lottoNumbersForTest(String winningNumbersInput) {
        return Arrays.stream(winningNumbersInput.split(COMMA_BLANK_DELIMITER))
                .map(number -> LottoNumber.valueOf(Integer.parseInt(number)))
                .collect(Collectors.toSet());
    }
}

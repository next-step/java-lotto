package lotto.domain.lotto;

import lotto.domain.PurchaseAmountOfMoney;
import lotto.domain.WinningNumbers;
import lotto.domain.lotto.strategy.LottoGeneratingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    LottoGeneratingStrategy lottoGeneratingStrategyStub = () -> {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        return Lotto.valueOf(lottoNumbers);
    };

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 7, 8, 9:3:5", "1, 2, 3, 4, 8, 9:4:50", "1, 2, 3, 4, 5, 9:5:1500", "1, 2, 3, 4, 5, 6:6:2000000"}, delimiter = ':')
    @DisplayName("statistics(): 로또의 결과(당첨 통계, 수익률)를 반환합니다.")
    void testStatistics(String winningNumberInput, int matchCount, double expectedRateOfReturn) {
        PurchaseAmountOfMoney purchaseAmountOfMoney = PurchaseAmountOfMoney.valueOf("1000");
        Lottos lottos = LottoStore.purchaseLotto(lottoGeneratingStrategyStub, purchaseAmountOfMoney.numberOfLottoToPurchase());
        WinningNumbers winningNumbers = WinningNumbers.valueOf(winningNumberInput);
        StatisticsOfLottos statisticsOfLottos = lottos.statistics(winningNumbers, purchaseAmountOfMoney);

        assertThat(statisticsOfLottos.numberOfMatchCount(matchCount)).isEqualTo(1);
        assertThat(statisticsOfLottos.rateOfReturn()).isEqualTo(expectedRateOfReturn);
    }
}
package lotto.domain.lotto;

import lotto.domain.*;
import lotto.domain.lotto.strategy.LottoGeneratingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.TestUtil.numbersForTest;
import static lotto.domain.lotto.strategy.LottoGeneratingStrategy.EMPTY_LOTTOS;
import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    LottoGeneratingStrategy lottoGeneratingStrategyStub = new LottoGeneratingStrategy() {
        @Override
        public Lottos lottos(int totalNumberOfLottoToPurchase, Lottos manualLottos) {
            Lotto lotto = Lotto.valueOf(Stream.of(1, 2, 3, 4, 5, 6)
                    .map(LottoNumber::valueOf)
                    .collect(Collectors.toList()));

            List<Lotto> lottos = IntStream.range(0, totalNumberOfLottoToPurchase)
                    .mapToObj(i -> lotto)
                    .collect(Collectors.toList());

            return Lottos.valueOf(lottos);
        }
    };

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 7, 8, 9:10:FIFTH:5", "1, 2, 3, 4, 8, 9:10:FOURTH:50", "1, 2, 3, 4, 5, 9:10:THIRD:1500", "1, 2, 3, 4, 5, 9:6:SECOND:30000", "1, 2, 3, 4, 5, 6:10:FIRST:2000000"}, delimiter = ':')
    @DisplayName("statistics(): 로또의 결과(당첨 통계, 수익률)를 반환합니다.")
    void testStatistics(String winningNumbersInput, int bonusNumberInput, Rank rank, double expectedRateOfReturn) {
        PurchaseAmountOfMoney purchaseAmountOfMoney = PurchaseAmountOfMoney.valueOf(1000);
        Lottos lottos = lottoGeneratingStrategyStub.lottos(purchaseAmountOfMoney.totalNumberOfLottoToPurchase(), EMPTY_LOTTOS);

        WinningNumbers winningNumbers = WinningNumbers.valueOf(numbersForTest(winningNumbersInput));
        BonusNumber bonusNumber = BonusNumber.newBonusNumberWithOutWinningNumbers(LottoNumber.valueOf(bonusNumberInput), winningNumbers);
        WinningAndBonusNumbers winningAndBonusNumbers = WinningAndBonusNumbers.newWinningAndBonusNumbers(winningNumbers, bonusNumber);

        StatisticsOfLottos statisticsOfLottos = lottos.statistics(winningAndBonusNumbers, purchaseAmountOfMoney);

        assertThat(statisticsOfLottos.numberOfMatchCount(rank)).isEqualTo(1);
        assertThat(statisticsOfLottos.rateOfReturn()).isEqualTo(expectedRateOfReturn);
    }

    @Test
    @DisplayName("bind(): Lottos 인스턴스 2개를 합하여 새로운 Lottos 인스턴스를 반환한다.")
    void testBind() {
        Lottos sizeOneLottos = lottoGeneratingStrategyStub.lottos(1, EMPTY_LOTTOS);
        Lottos sizeTwoLottos = lottoGeneratingStrategyStub.lottos(2, EMPTY_LOTTOS);
        Lottos sizeThreeLottos = sizeOneLottos.bind(sizeTwoLottos);

        assertThat(sizeThreeLottos.lottos().size()).isEqualTo(3);
    }
}

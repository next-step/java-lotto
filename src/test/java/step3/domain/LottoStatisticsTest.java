package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoMachine;
import step3.domain.lotto.LottoNumber;
import step3.domain.lotto.LottoRank;
import step3.domain.lotto.LottoStatistics;
import step3.domain.lotto.Profit;
import step3.domain.lotto.ResultOfLottos;
import step3.domain.lotto.WinOfLotto;
import step3.domain.money.Cache;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static step3.domain.LottoNumbersFactory.buildLottoNumbers;

class LottoStatisticsTest {

    private WinOfLotto givenWinOfLotto;

    @BeforeEach
    void setUp() {
        List<LottoNumber> winOfLottoNumbers = buildLottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumber givenBonusNumber = new LottoNumber(10);
        givenWinOfLotto = new WinOfLotto(winOfLottoNumbers, givenBonusNumber);
    }

    @Test
    void 보너스를_폼함한_2등의_금액은_150000원이다() {
        // Given
        Map<LottoRank, Integer> expectedResult = new HashMap<>();
        expectedResult.put(LottoRank.find(5, true), 1);

        ResultOfLottos expectedResultOfLottos = new ResultOfLottos(expectedResult);

        List<LottoNumber> givenLottoNumbers = buildLottoNumbers(1, 2, 3, 4, 8, 10);

        LottoMachine lottoMachine = new LottoMachine(() -> givenLottoNumbers);
        List<Lotto> lottos = lottoMachine.sell(new Cache(1000));

        // When
        ResultOfLottos actualResultOfLottos = LottoStatistics.calcLottoOfStatistics(givenWinOfLotto, lottos);

        // Then
        assertThat(expectedResultOfLottos).isEqualTo(actualResultOfLottos);
        assertThat(expectedResultOfLottos.sumMoney()).isEqualTo(new Cache(30_000_000));
    }

    @Test
    void 당첨된_통계를_보여준다() {
        // Given
        Map<LottoRank, Integer> expectedLottoStrategy = new HashMap<>();
        LottoRank three_match = LottoRank.find(3, false);
        expectedLottoStrategy.put(three_match, 1);

        ResultOfLottos expectedResultOfLottos = new ResultOfLottos(expectedLottoStrategy);

        List<LottoNumber> givenLottoNumbers = buildLottoNumbers(1, 2, 3, 44, 9, 11);

        LottoMachine lottoMachine = new LottoMachine(() -> givenLottoNumbers);
        List<Lotto> lottos = lottoMachine.sell(new Cache(1000));

        // When
        ResultOfLottos resultOfLottos = LottoStatistics.calcLottoOfStatistics(givenWinOfLotto, lottos);

        // Then
        assertThat(expectedResultOfLottos).isEqualTo(resultOfLottos);
    }

    @DisplayName("3등에 당첨되면 수익률은 5가 된다")
    @Test
    void profilt() {
        Profit expectedLottoProfit = new Profit(5);
        List<LottoNumber> givenLottoNumbers = buildLottoNumbers(1, 2, 3, 44, 45, 22);

        LottoMachine lottoMachine = new LottoMachine(() -> givenLottoNumbers);
        List<Lotto> lottos = lottoMachine.sell(new Cache(1000));

        ResultOfLottos resultOfLottos = LottoStatistics.calcLottoOfStatistics(givenWinOfLotto, lottos);

        // When
        Profit profit = LottoStatistics.calculateLottoProfit(resultOfLottos, lottos.size());

        // Then
        assertThat(profit).isEqualTo(expectedLottoProfit);
    }


}
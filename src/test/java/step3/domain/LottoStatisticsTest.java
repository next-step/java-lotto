package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoMachine;
import step3.domain.lotto.LottoRank;
import step3.domain.lotto.LottoNumber;
import step3.domain.lotto.LottoStatistics;
import step3.domain.lotto.Profit;
import step3.domain.lotto.ResultOfLottos;
import step3.domain.lotto.WinOfLotto;
import step3.domain.money.Cache;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoStatisticsTest {

    private WinOfLotto givenWinOfLotto;

    @BeforeEach
    void setUp() {
        Lotto winOfLottoNumbers = Lotto.create(Arrays
            .asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        LottoNumber givenBonusNumber = new LottoNumber(10);
        givenWinOfLotto = new WinOfLotto(winOfLottoNumbers, givenBonusNumber);
    }

    @Test
    void 보너스를_폼함한_2등의_금액은_150000원이다() {
        // Given
        Map<LottoRank, Integer> expectedResult = new HashMap<>();
        expectedResult.put(LottoRank.find(5, true), 1);

        ResultOfLottos expectedResultOfLottos = new ResultOfLottos(expectedResult);

        LottoNumber[] givenLottoNumbers = {new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(7),
            new LottoNumber(10)};

        LottoMachine lottoMachine = new LottoMachine(new InputNumberStrategy(Arrays.asList(givenLottoNumbers)));
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

        LottoNumber[] givenNumbers = {new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(11), new LottoNumber(12),
            new LottoNumber(13)};

        LottoMachine lottoMachine = new LottoMachine(new InputNumberStrategy(Arrays.asList(givenNumbers)));
        List<Lotto> lottos = lottoMachine.sell(new Cache(1000));

        // When
        ResultOfLottos resultOfLottos = LottoStatistics.calcLottoOfStatistics(givenWinOfLotto, lottos);

        // Then
        assertThat(expectedResultOfLottos).isEqualTo(resultOfLottos);
    }

    @DisplayName("3등에 당첨되면 수익률은 5")
    @Test
    void profilt() {
        Profit expectedLottoProfit = new Profit(5);
        LottoNumber[] givenNumbers = {new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(12), new LottoNumber(13),
            new LottoNumber(14)};
        LottoMachine lottoMachine = new LottoMachine(new InputNumberStrategy(Arrays.asList(givenNumbers)));
        List<Lotto> lottos = lottoMachine.sell(new Cache(1000));

        ResultOfLottos resultOfLottos = LottoStatistics.calcLottoOfStatistics(givenWinOfLotto, lottos);

        // When
        Profit profit = LottoStatistics.calculateLottoProfit(resultOfLottos, lottos.size());

        // Then
        assertThat(profit).isEqualTo(expectedLottoProfit);
    }
}
package step4.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.lotto.LottoMachine;
import step4.domain.lotto.LottoMatch;
import step4.domain.lotto.LottoNumber;
import step4.domain.lotto.Lottos;
import step4.domain.lotto.Profit;
import step4.domain.lotto.WinOfLotto;
import step4.domain.money.Cache;
import step4.domain.lotto.LottoRank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static step4.LottoNumbersFactory.buildLottoNumbers;

class LottosTest {

    private WinOfLotto givenWinOfLotto;

    @BeforeEach
    void setUp() {
        List<LottoNumber> winOfLottoNumbers = buildLottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumber givenBonusNumber = new LottoNumber(10);
        givenWinOfLotto = new WinOfLotto(winOfLottoNumbers, givenBonusNumber);
    }

    @CsvSource(value = {"6,6,false,2000000000", "5,10,true,30000000", "5,22,false,1500000"})
    @ParameterizedTest(name = "로또당첨 개수가 {0}개이면서 보너스가 {2}이면 당첨 금액은 {3}원이다")
    void lottoMatch(int matchCount, int bonusNumber, boolean bonusMatch, int money) {
        // Given
        Map<LottoRank, Integer> expectedResult = new HashMap<>();
        expectedResult.put(LottoRank.find(matchCount, bonusMatch), 1);

        LottoMatch expectedLottoMatch = new LottoMatch(expectedResult);

        List<LottoNumber> givenLottoNumbers = buildLottoNumbers(1, 2, 3, 4, 5, bonusNumber);

        LottoMachine lottoMachine = new LottoMachine(() -> givenLottoNumbers);
        Lottos lottos = lottoMachine.sell(new Cache(1000));

        // When
        LottoMatch actualLottoMatch = lottos.match(givenWinOfLotto);

        // Then
        assertThat(expectedLottoMatch).isEqualTo(actualLottoMatch);
        assertThat(expectedLottoMatch.sumMoney()).isEqualTo(new Cache(money));
    }

    @Test
    void 당첨된_통계를_보여준다() {
        // Given
        Map<LottoRank, Integer> expectedLottoStrategy = new HashMap<>();
        LottoRank three_match = LottoRank.find(3, false);
        expectedLottoStrategy.put(three_match, 1);

        LottoMatch expectedLottoMatch = new LottoMatch(expectedLottoStrategy);

        List<LottoNumber> givenLottoNumbers = buildLottoNumbers(1, 2, 3, 44, 9, 11);

        LottoMachine lottoMachine = new LottoMachine(() -> givenLottoNumbers);
        Lottos lottos = lottoMachine.sell(new Cache(1000));

        // When
        LottoMatch lottoMatch = lottos.match(givenWinOfLotto);

        // Then
        assertThat(expectedLottoMatch).isEqualTo(lottoMatch);
    }


    @DisplayName("3등에 당첨되면 수익률은 5가 된다")
    @Test
    void profilt() {
        List<LottoNumber> givenLottoNumbers = buildLottoNumbers(1, 2, 3, 44, 45, 22);

        LottoMachine lottoMachine = new LottoMachine(() -> givenLottoNumbers);
        Lottos lottos = lottoMachine.sell(new Cache(1000));

        LottoMatch lottoMatch = lottos.match(givenWinOfLotto);

        // When
        Profit profit = lottoMatch.calcProfit(lottos.size());

        // Then
        assertThat(profit).isEqualTo(new Profit(5));
    }
}
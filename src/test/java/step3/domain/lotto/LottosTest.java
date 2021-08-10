package step3.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.money.Cache;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static step3.domain.LottoNumbersFactory.buildLottoNumbers;

class LottosTest {

    private WinOfLotto givenWinOfLotto;

    @BeforeEach
    void setUp() {
        List<LottoNumber> winOfLottoNumbers = buildLottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumber givenBonusNumber = new LottoNumber(10);
        givenWinOfLotto = new WinOfLotto(winOfLottoNumbers, givenBonusNumber);
    }

    @Test
    void 로또_맞은_개수가_6개_이면서_보너스를_포함하지_않는다면_당첨_금액은_2_000_000_000원이다() {
        // Given
        Map<LottoRank, Integer> expectedResult = new HashMap<>();
        expectedResult.put(LottoRank.find(6, false), 1);

        LottoMatch expectedLottoMatch = new LottoMatch(expectedResult);

        List<LottoNumber> givenLottoNumbers = buildLottoNumbers(1, 2, 3, 4, 5, 6);

        LottoMachine lottoMachine = new LottoMachine(() -> givenLottoNumbers);
        Lottos lottos = lottoMachine.sell(new Cache(1000));

        // When
        LottoMatch actualLottoMatch = lottos.match(givenWinOfLotto);

        // Then
        assertThat(expectedLottoMatch).isEqualTo(actualLottoMatch);
        assertThat(expectedLottoMatch.sumMoney()).isEqualTo(new Cache(2_000_000_000));
    }

    @Test
    void 로또_맞은_개수가_6개_이면서_보너스를_포함한다면_당첨_금액은_30_000_000원이다() {
        // Given
        Map<LottoRank, Integer> expectedResult = new HashMap<>();
        expectedResult.put(LottoRank.find(6, true), 1);

        LottoMatch expectedLottoMatch = new LottoMatch(expectedResult);

        List<LottoNumber> givenLottoNumbers = buildLottoNumbers(1, 2, 3, 4, 5, 10);

        LottoMachine lottoMachine = new LottoMachine(() -> givenLottoNumbers);
        Lottos lottos = lottoMachine.sell(new Cache(1000));

        // When
        LottoMatch actualLottoMatch = lottos.match(givenWinOfLotto);

        // Then
        assertThat(expectedLottoMatch).isEqualTo(actualLottoMatch);
        assertThat(expectedLottoMatch.sumMoney()).isEqualTo(new Cache(30_000_000));
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
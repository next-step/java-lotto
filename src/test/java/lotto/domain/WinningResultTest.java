package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class WinningResultTest {
    private WinningLotto testWinningLotto;

    @BeforeEach
    void beforeEach() {
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto testLotto = Lotto.fromNumbers(testNumbers);
        LottoNumber testBonus = LottoNumber.from(7);
        testWinningLotto = new WinningLotto(testLotto, testBonus);
    }

    @DisplayName("각 로또의 결과를 RANK와 해당 RANK의 개수로 저장한다")
    @Test
    void 결과가_1등_1개_2등_1개_3등_2개인_경우() {
        List<Integer> first = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> second = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> third1 = Arrays.asList(11, 2, 3, 4, 5, 6);
        List<Integer> third2 = Arrays.asList(1, 2, 3, 41, 5, 6);

        List<Lotto> lottos = Arrays.asList(
                Lotto.fromNumbers(first),
                Lotto.fromNumbers(second),
                Lotto.fromNumbers(third1),
                Lotto.fromNumbers(third2)
        );

        Lottos testLottos = Lottos.withListLotto(lottos);
        WinningResult winningResult = WinningResult.of(testLottos, testWinningLotto);

        Map<Rank, Integer> actual = winningResult.getResult();
        assertThat(actual.get(Rank.FIRST)).isEqualTo(1);
        assertThat(actual.get(Rank.SECOND)).isEqualTo(1);
        assertThat(actual.get(Rank.THIRD)).isEqualTo(2);
        assertThat(actual.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(actual.get(Rank.FIFTH)).isEqualTo(0);
    }

    @DisplayName("각 로또의 결과를 토대로 당첨 상금과 수익률을 계산한다")
    @Test
    void 로또_3개_중_4등_1개_5등_1개_꽝_1개인_경우() {
        List<Integer> fourth = Arrays.asList(11, 21, 3, 4, 5, 6);
        List<Integer> fifth = Arrays.asList(1, 2, 3, 14, 15, 16);
        List<Integer> none = Arrays.asList(11, 12, 13, 14, 15, 6);

        List<Lotto> lottos = Arrays.asList(
            Lotto.fromNumbers(fourth),
            Lotto.fromNumbers(fifth),
            Lotto.fromNumbers(none)
        );

        Lottos testLottos = Lottos.withListLotto(lottos);

        WinningResult winningResult = WinningResult.of(testLottos, testWinningLotto);

        BigDecimal actualProfit = winningResult.calculateProfitRate(3000);
        BigDecimal expectedProfit = new BigDecimal(55000).divide(new BigDecimal(3000), 2, RoundingMode.DOWN);
        BigDecimal actualPrize = winningResult.calculatePrizeMoney();

        assertThat(actualPrize).isEqualTo(new BigDecimal(55000));
        assertThat(actualProfit).isEqualTo(expectedProfit);
    }
}

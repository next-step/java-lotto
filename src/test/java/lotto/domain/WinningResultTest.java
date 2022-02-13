package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
        Lotto testLotto = Lotto.from(testNumbers);
        LottoNumber testBonus = LottoNumber.from(7);
        testWinningLotto = new WinningLotto(testLotto, testBonus);
    }

    @DisplayName("각 로또의 결과를 토대로 당첨 상금과 수익률을 계산한다")
    @Test
    void 로또_3개_중_4등_1개_5등_1개_꽝_1개인_경우() {
        List<Integer> fourth = Arrays.asList(11, 21, 3, 4, 5, 6);
        List<Integer> fifth = Arrays.asList(1, 2, 3, 14, 15, 16);
        List<Integer> none = Arrays.asList(11, 12, 13, 14, 15, 6);

        List<Lotto> lottos = Arrays.asList(
            Lotto.from(fourth),
            Lotto.from(fifth),
            Lotto.from(none)
        );

        Map<Rank, Integer> rankMap = testWinningLotto.mapResult(Lottos.withListLotto(lottos));
        WinningResult testWinningResult = new WinningResult(rankMap);

        double actualProfit = testWinningResult.calculateProfitRate(3000);
        double expectedProfit = (double) 55000 / 3000;
        long actualPrize = testWinningResult.calculatePrizeMoney();

        assertThat(actualPrize).isEqualTo(55000);
        assertThat(actualProfit).isEqualTo(expectedProfit);
    }
}

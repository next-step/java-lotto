package step2.domain.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.lotto.*;
import step2.utils.ProfitTestUtil;
import step2.vo.Rank;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {
    @Test
    @DisplayName("1등(6개 일치) 3개, 총 3개 구매에 대한 통계 테스트")
    void matchSuccessTest1() {
        final LottoNumbers winningLottoValue = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final Lottos wonLottos = new Lottos(Arrays.asList(
                new Lotto(winningLottoValue),
                new Lotto(winningLottoValue),
                new Lotto(winningLottoValue)));
        System.out.println(wonLottos);

        final WinningLotto standardLotto = new WinningLotto(winningLottoValue, new LottoNumber(45));
        final Statistics actual = standardLotto.match(wonLottos);
        System.out.println(actual);

        final Profit expectedStatistics = ProfitTestUtil.createProfit(Rank.FIRST, 3, 3);
        final Match expectedMatch = new Match(Rank.FIRST, 3);
        final Statistics expected = new Statistics(expectedStatistics, expectedMatch);
        System.out.println(expected);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("5등(3개 일치) 3개, 총 3개 구매에 대한 통계 테스트")
    void matchSuccessTest2() {
        final LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 10, 11, 12));
        final Lottos wonLottos = new Lottos(Arrays.asList(
                new Lotto(lottoNumbers),
                new Lotto(lottoNumbers),
                new Lotto(lottoNumbers)));
        System.out.println(wonLottos);

        final WinningLotto standardLotto = new WinningLotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(45));
        Statistics actual = standardLotto.match(wonLottos);
        System.out.println(actual);

        final Profit expectedStatistics = ProfitTestUtil.createProfit(Rank.FIFTH, 3, 3);
        final Match expectedMatch = new Match(Rank.FIFTH, 3);
        final Statistics expected = new Statistics(expectedStatistics, expectedMatch);
        System.out.println(expected);

        assertThat(actual).isEqualTo(expected);
    }
}

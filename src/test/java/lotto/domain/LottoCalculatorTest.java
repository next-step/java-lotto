package lotto.domain;

import lotto.LottoCalculatorTestHelper;
import lotto.domain.type.RankType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCalculatorTest {
    private Lotto lastWeekLotto;

    private String bonusBall;

    private LottoCalculatorTestHelper lottoCalculatorTestHelper;

    @BeforeEach
    void setUp() {
        Lotto noRankLotto = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lotto rank1Lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto rank2Lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto rank3Lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
        Lotto rank4Lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9));
        Lotto rank5Lotto = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));
        bonusBall = "7";

        lastWeekLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoCalculatorTestHelper = new LottoCalculatorTestHelper(noRankLotto,
                rank1Lotto,
                rank2Lotto,
                rank3Lotto,
                rank4Lotto,
                rank5Lotto);
    }

    @Test
    void getWinningPercentage() {
        int investment = 14_000;
        String winningPercentageValue = "0.35";
        List<Lotto> lottos = lottoCalculatorTestHelper.getRankLotto(RankType.RANK5, 1);
        LottoCalculator lottoCalculator = new LottoCalculator(new WinningLotto(lastWeekLotto, bonusBall), lottos);

        String winningPercentage = lottoCalculator.getWinningPercentage(investment).toString();

        assertThat(winningPercentage).isEqualTo(winningPercentageValue);
    }

    @Test
    void getCount() {
        int expected = 10;
        List<Lotto> lottos = lottoCalculatorTestHelper.getRankLotto(RankType.RANK1, expected);
        LottoCalculator lottoCalculator = new LottoCalculator(new WinningLotto(lastWeekLotto, bonusBall), lottos);

        assertThat(lottoCalculator.getCount(RankType.RANK1)).isEqualTo(expected);
        assertThat(lottoCalculator.getCount(RankType.NO_RANK)).isEqualTo(0);
    }
}

package lotto.domain;

import lotto.type.RankType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCalculatorTest {
    private Lotto noRankLotto;
    private Lotto rank1Lotto;
    private Lotto rank2Lotto;
    private Lotto rank3Lotto;
    private Lotto rank4Lotto;
    private Lotto rank5Lotto;
    private String bonusBall;

    private Lotto lastWeekLotto;
    private List<Lotto> lottos;

    private LottoCalculator lottoCalculator;

    @BeforeEach
    void setUp() {
        noRankLotto = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        rank1Lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        rank2Lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        rank3Lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
        rank4Lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9));
        rank5Lotto = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));

        bonusBall = "7";

        lastWeekLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos = new ArrayList<>();
    }

    @Test
    void getWinningPercentage() {
        int investment = 14_000;
        String winningPercentageValue = "0.35";
        addRank(RankType.RANK5, 1);
        lottoCalculator = new LottoCalculator(new WinningLotto(lastWeekLotto, bonusBall), lottos);

        String winningPercentage = lottoCalculator.getWinningPercentage(investment).toString();

        assertThat(winningPercentage).isEqualTo(winningPercentageValue);
    }

    @Test
    void getCount() {
        int expected = 10;
        addRank(RankType.RANK1, expected);
        lottoCalculator = new LottoCalculator(new WinningLotto(lastWeekLotto, bonusBall), lottos);

        assertThat(lottoCalculator.getCount(RankType.RANK1)).isEqualTo(expected);
        assertThat(lottoCalculator.getCount(RankType.NO_RANK)).isEqualTo(0);
    }

    private void addRank(RankType type, int addCount) {
        Lotto lotto = noRankLotto;

        if (type == RankType.RANK1) {
            lotto = rank1Lotto;
        }

        if (type == RankType.RANK2) {
            lotto = rank2Lotto;
        }

        if (type == RankType.RANK3) {
            lotto = rank3Lotto;
        }

        if (type == RankType.RANK4) {
            lotto = rank4Lotto;
        }

        if (type == RankType.RANK5) {
            lotto = rank5Lotto;
        }

        for (int i = 0; i < addCount; i++) {
            lottos.add(lotto);
        }
    }
}

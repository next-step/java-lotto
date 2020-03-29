package lotto.domain;

import lotto.type.RankType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCalculatorTest {
    private Lotto lastWeekLotto;
    private List<Lotto> lottos;

    private LottoCalculator lottoCalculator;

    @BeforeEach
    void setUp() {
        lastWeekLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos = Arrays.asList(new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
                new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
                new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                new Lotto(Arrays.asList(23, 25, 33, 36, 39, 41)),
                new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)),
                new Lotto(Arrays.asList(5, 9, 38, 41, 43, 44)),
                new Lotto(Arrays.asList(2, 8, 9, 18, 19, 21)),
                new Lotto(Arrays.asList(13, 14, 18, 21, 23, 35)),
                new Lotto(Arrays.asList(17, 21, 29, 37, 42, 45)),
                new Lotto(Arrays.asList(3, 8, 27, 30, 35, 44)));

        lottoCalculator = new LottoCalculator(lastWeekLotto, lottos);
    }

    @Test
    void getWinningPercentage() {
        int investment = 14_000;
        String winningPercentageValue = "0.35";

        String winningPercentage = lottoCalculator.getWinningPercentage(investment).toString();

        assertThat(winningPercentage).isEqualTo(winningPercentageValue);
    }

    @Test
    void getCount() {
        int noRankCount = lottoCalculator.getCount(RankType.NO_RANK);
        int rank4Count = lottoCalculator.getCount(RankType.RANK4);
        int rank1Count = lottoCalculator.getCount(RankType.RANK1);

        assertThat(noRankCount).isEqualTo(13);
        assertThat(rank4Count).isEqualTo(1);
        assertThat(rank1Count).isEqualTo(0);
    }
}

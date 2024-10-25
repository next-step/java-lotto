package refactoringlotto;

import org.junit.jupiter.api.Test;
import refactoringlotto.domain.LottoWinningCounts;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningCountsTest {


    public static final int LOTTO_RANK = 4;
    public static final Map<Integer, Integer> WINNING_COUNTS_MAP = Map.of(1, 0, 2, 0, 3, 0, 4, 1);

    @Test
    public void 당첨횟수저장_테스트() {
        LottoWinningCounts lottoWinningCounts = new LottoWinningCounts();
        int lottoRank = LOTTO_RANK;
        lottoWinningCounts.updateWinningCount(lottoRank);
        assertThat(lottoWinningCounts).isEqualTo(new LottoWinningCounts(WINNING_COUNTS_MAP));

    }
}

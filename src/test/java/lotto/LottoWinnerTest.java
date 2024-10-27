package lotto;

import org.junit.jupiter.api.Test;
import lotto.domain.LottoWinner;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinnerTest {


    public static final int LOTTO_RANK = 4;
    public static final Map<Integer, Integer> WINNING_COUNT_MAP = Map.of(1, 0, 2, 0, 3, 0, 4, 1);
    public static final Map<Integer, Integer> WINNING_COUNTS_MAP = Map.of(1, 1, 2, 1, 3, 0, 4, 0);
    public static final List<Integer> WINNING_COUNTS_LIST = List.of(1,2);
    public static final int WINNING_AMOUNT = 5000;
    public static final double EXPECTED_MARGIN = 5.0;

    @Test
    public void 당첨횟수저장_테스트() {
        LottoWinner lottoWinner = new LottoWinner();
        lottoWinner.updateWinningCount(LOTTO_RANK);
        assertThat(lottoWinner).isEqualTo(new LottoWinner(WINNING_COUNT_MAP));
    }

    @Test
    public void 당첨횟수리스트_저장_테스트() {
        LottoWinner lottoWinner = new LottoWinner();
        lottoWinner.updateWinningCountList(WINNING_COUNTS_LIST);
        assertThat(lottoWinner).isEqualTo(new LottoWinner(WINNING_COUNTS_MAP));
    }

    @Test
    public void 당첨금액_테스트() {
        LottoWinner lottoWinner = new LottoWinner();
        lottoWinner.updateWinningCount(LOTTO_RANK);
        assertThat(lottoWinner.winningAmount()).isEqualTo(WINNING_AMOUNT);
    }

    @Test
    public void 당첨비율_테스트() {
        int purchaseAmount = 1000;
        LottoWinner lottoWinner = new LottoWinner();
        lottoWinner.updateWinningCount(LOTTO_RANK);
        assertThat(lottoWinner.calculateMarginPercent(purchaseAmount)).isEqualTo(EXPECTED_MARGIN);
    }
}

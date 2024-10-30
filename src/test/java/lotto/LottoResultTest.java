package lotto;

import lotto.domain.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {


    public static final int LOTTO_RANK = 5;
    public static final Map<Integer, Integer> WINNING_COUNT_MAP = Map.of(1, 0, 2, 0, 3, 0, 4, 0,5,1);
    public static final Map<Integer, Integer> WINNING_COUNTS_MAP = Map.of(1, 1, 2, 1, 3, 0, 4, 0,5,0);
    public static final List<Integer> WINNING_COUNTS_LIST = List.of(1, 2);
    public static final int WINNING_AMOUNT = 5000;
    public static final double EXPECTED_MARGIN = 5.0;
    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }


    @Test
    public void 당첨횟수저장_테스트() {

        lottoResult.updateWinningCount(LOTTO_RANK);
        assertThat(lottoResult).isEqualTo(new LottoResult(WINNING_COUNT_MAP));
    }

    @Test
    public void 당첨횟수리스트_저장_테스트() {
        lottoResult.updateWinningCountList(WINNING_COUNTS_LIST);
        assertThat(lottoResult).isEqualTo(new LottoResult(WINNING_COUNTS_MAP));
    }

    @Test
    public void 당첨금액_테스트() {
        lottoResult.updateWinningCount(LOTTO_RANK);
        assertThat(lottoResult.winningAmount()).isEqualTo(WINNING_AMOUNT);
    }

    @Test
    public void 당첨비율_테스트() {
        int purchaseAmount = 1000;
        lottoResult.updateWinningCount(LOTTO_RANK);
        assertThat(lottoResult.calculateMarginPercent().calculateMarginPercent(purchaseAmount)).isEqualTo(EXPECTED_MARGIN);
    }

    @Test
    public void 보너스볼당첨_테스트() {
        int purchaseAmount = 1000;
        lottoResult.updateWinningCount(LOTTO_RANK);
        assertThat(lottoResult.calculateMarginPercent().calculateMarginPercent(purchaseAmount)).isEqualTo(EXPECTED_MARGIN);
    }
}

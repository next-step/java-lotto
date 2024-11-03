package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    public static final int LOTTO_RANK = 5;
    public static final double EXPECTED_MARGIN = 5.0;
    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }


    @Test
    public void 당첨횟수저장_테스트() {
        final LottoResult testResult = new LottoResult(List.of(LottoRank.FIFTH));
        lottoResult.updateWinningCount(LottoRank.FIFTH);
        assertThat(testResult).isEqualTo(lottoResult);
    }

    @Test
    public void 당첨금액_테스트() {
        final int winningAmount = 5000;
        lottoResult.updateWinningCount(LottoRank.FIFTH);
        assertThat(lottoResult.winningAmount()).isEqualTo(winningAmount);
    }

    @Test
    public void 당첨비율_테스트() {
        int purchaseAmount = 1000;
        lottoResult.updateWinningCount(LottoRank.FIFTH);
        assertThat(lottoResult.calculateMarginPercent(purchaseAmount)).isEqualTo(EXPECTED_MARGIN);
    }

    @Test
    public void 당첨개수_테스트() {
        lottoResult.updateWinningCount(LottoRank.FIFTH);
        int expected_count = 1;
        assertThat(lottoResult.countRank(LottoRank.FIFTH)).isEqualTo(expected_count);
    }

}

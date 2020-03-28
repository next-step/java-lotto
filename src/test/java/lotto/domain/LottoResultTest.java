package lotto.domain;

import lotto.Fixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private static final int ONE = 1;

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult(Arrays.asList(WinningType.THREE_MATCH), Fixture.lottoBundleHasFiveLotto());
    }

    @DisplayName("로또 수익률 계산")
    @Test
    void calculateEarnRate() {
        BigDecimal earningRate = lottoResult.calculateEarningRate();
        assertThat(earningRate.intValue()).isEqualTo(BigDecimal.ONE.intValue());
    }

    @DisplayName("로또 당첨 개수 계산")
    @Test
    void countByWinningType() {
        long count = lottoResult.countByWinningtype(WinningType.THREE_MATCH);
        assertThat(count).isEqualTo(ONE);
    }
}
package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningCountDecisionTest {

    public static final int EXPECTED_AMOUNT = 5000;
    public static final int EXPECTED_RANK = 4;
    public static final int TEST_WINNING_NUMBER_COUNT = 3;

    @Test
    void convertMatchingNumberToRank_테스트() {
        assertThat(LottoWinningCountDecision.convertMatchingNumberToRank(TEST_WINNING_NUMBER_COUNT)).isEqualTo(EXPECTED_RANK);
    }

    @Test
    void convertMatchingRankToAmount_테스트() {
        assertThat(LottoWinningCountDecision.convertMatchingRankToAmount(EXPECTED_RANK)).isEqualTo(EXPECTED_AMOUNT);
    }

    @Test
    void convertRankToMatchingNumber_테스트() {
        assertThat(LottoWinningCountDecision.convertRankToMatchingNumber(EXPECTED_RANK)).isEqualTo(TEST_WINNING_NUMBER_COUNT);
    }
}
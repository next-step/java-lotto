package lotto.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {
    private final static int FIRST_RANK_COUNT = 1;
    private final static int SECOND_RANK_COUNT = 2;
    private final static int THIRD_RANK_COUNT = 3;
    private final static int FOURTH_RANK_COUNT = 4;
    LottoResults lottoResults;

    @BeforeEach
    void setUp() {
        lottoResults = new LottoResults();

        putLottoResults(LottoRank.FIRST, FIRST_RANK_COUNT);
        putLottoResults(LottoRank.SECOND, SECOND_RANK_COUNT);
        putLottoResults(LottoRank.THIRD, THIRD_RANK_COUNT);
        putLottoResults(LottoRank.FOURTH, FOURTH_RANK_COUNT);
    }

    private void putLottoResults(final LottoRank lottoRank, final int firstRankCount) {
        for (int i = 0; i < firstRankCount; i++) {
            lottoResults.incrementRankCount(lottoRank);
        }
    }

    @ParameterizedTest
    @MethodSource("inputWithLottoRankAndRankCount")
    @DisplayName("getCount 메서드의 입력으로 LottoRank를 넣으면, LottoResults에서 해당 Rank가 몇개 존재하는지 반환한다.")
    void testGetCount(final LottoRank lottoRank, final int rankCount) {
        assertThat(lottoResults.getCount(lottoRank)).isEqualTo(rankCount);
    }


    @ParameterizedTest
    @MethodSource("inputWithLottoRankAndRankCount")
    @DisplayName("incrementRankCount 메서드의 입력으로 LottoRank를 넣으면, LottoResults에서 해당 Rank의 개수를 1개 증가시킨다.")
    void testIncrementRankCount(final LottoRank lottoRank, final int rankCount) {
        lottoResults.incrementRankCount(lottoRank);
        assertThat(lottoResults.getCount(lottoRank)).isEqualTo(rankCount + 1);
    }

    @Test
    @DisplayName("toString을 사용하면, 당첨 통계 값을 반환한다.")
    void testToString() {
        assertThat(lottoResults.toString())
                .isEqualTo(
                        "6개 일치 (2000000000원)- 4개\n" +
                                "5개 일치 (1500000원)- 3개\n" +
                                "4개 일치 (50000원)- 2개\n" +
                                "3개 일치 (5000원)- 1개\n"
                );
    }

    public static Stream<Arguments> inputWithLottoRankAndRankCount() {
        return Stream.of(
                Arguments.of(LottoRank.FIRST, FIRST_RANK_COUNT),
                Arguments.of(LottoRank.SECOND, SECOND_RANK_COUNT),
                Arguments.of(LottoRank.THIRD, THIRD_RANK_COUNT),
                Arguments.of(LottoRank.FOURTH, FOURTH_RANK_COUNT)
        );
    }

    @Test
    @DisplayName("getTotalPrizeMoney 메서드를 사용하면, 총 상금을 반환한다.")
    void testGetTotalPrizeMoney() {
        //given
        long expectedTotalPrizeMoney = getExpectedTotalPrizeMoney();

        //when
        long totalPrizeMoney = lottoResults.getTotalPrizeMoney();

        //then
        assertThat(totalPrizeMoney).isEqualTo(expectedTotalPrizeMoney);
    }

    private long getExpectedTotalPrizeMoney() {
        return (long) LottoRank.FIRST.getPrizeMoney() * FIRST_RANK_COUNT
                + (long) LottoRank.SECOND.getPrizeMoney() * SECOND_RANK_COUNT
                + (long) LottoRank.THIRD.getPrizeMoney() * THIRD_RANK_COUNT
                + (long) LottoRank.FOURTH.getPrizeMoney() * FOURTH_RANK_COUNT;
    }

    @Test
    @DisplayName("calculateRateOfReturn 메서드의 입력으로 구매 금액을 넣으면, 수익률을 반환한다.")
    void testCalculateRateOfReturn() {
        //given
        final int paymentAmount = 1000;
        final double expectedRateOfReturn = ((double) getExpectedTotalPrizeMoney()) / paymentAmount;

        //when
        final double rateOfReturn = lottoResults.calculateRateOfReturn(paymentAmount);

        //then
        assertThat(rateOfReturn).isEqualTo(expectedRateOfReturn);
    }
}

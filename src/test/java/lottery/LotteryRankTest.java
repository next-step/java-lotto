package lottery;

import lottery.domain.LotteryRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryRankTest {
/*
    @DisplayName("LotteryRanks Enum 값 비교 테스트")
    @ParameterizedTest
    @MethodSource("mockLotteryRanksBuilder")
    public void compareLotteryRanksEnum(LotteryRank expectedRank, int index) {
        LotteryRank lotteryRank = LotteryRank.values()[index];

        assertThat(lotteryRank).isEqualTo(expectedRank);
    }

    @DisplayName("LotteryRanks Enum 상금 합계 기능 테스트")
    @ParameterizedTest
    @MethodSource("mockLotteryRanksBuilder")
    public void calculatePrizeMoneySum(LotteryRank expectedRank, int winnerTicketCounts, double expectedSum) {
       double prizeMoneySum = expectedRank.calculatePrizeMoneySum(winnerTicketCounts);

       assertThat(prizeMoneySum).isEqualTo(expectedSum);
    }

    private static Stream<Arguments> mockLotteryRanksBuilder() {
        return Stream.of(
                Arguments.of(LotteryRank.FIRST_PRIZE, 0, 0),
                Arguments.of(LotteryRank.SECOND_PRIZE, 1, 1500000),
                Arguments.of(LotteryRank.THIRD_PRIZE, 2, 100000),
                Arguments.of(LotteryRank.FOURTH_PRIZE, 3, 15000)
        );
    };*/


}

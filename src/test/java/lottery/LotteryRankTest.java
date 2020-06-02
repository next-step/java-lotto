package lottery;

import lottery.domain.LotteryRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryRankTest {

    private static Stream<Arguments> mockLotteryRanksBuilder() {
        return Stream.of(
                Arguments.of(LotteryRank.FIRST_PRIZE, 0, 0),
                Arguments.of(LotteryRank.SECOND_PRIZE, 1, 30_000_000),
                Arguments.of(LotteryRank.THIRD_PRIZE, 2, 1_500_000 * 2),
                Arguments.of(LotteryRank.FOURTH_PRIZE, 3, 50_000 * 3),
                Arguments.of(LotteryRank.FIFTH_PRIZE, 4, 5000 * 4),
                Arguments.of(LotteryRank.MISS, 5, 0)
        );
    }

    private static Stream<Arguments> mockLotteryValueOfRankBuilder() {
        return Stream.of(
                Arguments.of(6, LotteryRank.FIRST_PRIZE),
                Arguments.of(5, LotteryRank.THIRD_PRIZE),
                Arguments.of(4, LotteryRank.FOURTH_PRIZE),
                Arguments.of(3, LotteryRank.FIFTH_PRIZE),
                Arguments.of(2, LotteryRank.MISS)
        );
    }

    @DisplayName("LotteryRanks Enum 값 비교 테스트")
    @ParameterizedTest
    @MethodSource("mockLotteryRanksBuilder")
    public void compareLotteryRanksEnum(LotteryRank expectedRank, int index) {
        LotteryRank lotteryRank = LotteryRank.values()[index];

        assertThat(lotteryRank).isEqualTo(expectedRank);
    }

    @DisplayName("맞춘 개수가 3 미만이면 MISS enum 반환")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    public void getMissEnum(int matchNumberCounts) {
        LotteryRank lotteryRank = LotteryRank.valueOf(matchNumberCounts, false);

        assertThat(lotteryRank).isEqualTo(LotteryRank.MISS);
    }

    @DisplayName("맞춘 개수에 따라서 적합한 랭크를 반환 받음")
    @ParameterizedTest
    @MethodSource("mockLotteryValueOfRankBuilder")
    public void getProperLotteryRank(int matchNumberCounts, LotteryRank expectedRank) {
        LotteryRank lotteryRank = LotteryRank.valueOf(matchNumberCounts, false);

        assertThat(lotteryRank).isEqualTo(expectedRank);
    }

    @DisplayName("맞춘 개수가 5개일 때 보너스볼 포함 여부에 따라 2등 3등 분리 반환")
    @Test
    public void getSecondOrThirdLotteryRank() {
        LotteryRank secondRank = LotteryRank.valueOf(5, true);
        LotteryRank thirdRank = LotteryRank.valueOf(5, false);

        assertThat(secondRank).isEqualTo(LotteryRank.SECOND_PRIZE);
        assertThat(thirdRank).isEqualTo(LotteryRank.THIRD_PRIZE);
    }

    @DisplayName("LotteryRanks Enum 상금 합계 기능 테스트")
    @ParameterizedTest
    @MethodSource("mockLotteryRanksBuilder")
    public void calculatePrizeMoneySum(LotteryRank expectedRank, int winnerTicketCounts, double expectedSum) {
        double prizeMoneySum = expectedRank.calculatePrizeMoneySum(winnerTicketCounts);

        assertThat(prizeMoneySum).isEqualTo(expectedSum);
    }
}

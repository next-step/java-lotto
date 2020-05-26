package lottery;

import lottery.domain.LotteryRanks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryRanksTest {

    @DisplayName("LotteryRanks Enum 값 비교 테스트")
    @ParameterizedTest
    @MethodSource("mockLotteryRanksBuilder")
    public void compareLotteryRanksEnum(LotteryRanks expectedRank, int index) {
        LotteryRanks lotteryRank = LotteryRanks.values()[index];

        assertThat(lotteryRank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> mockLotteryRanksBuilder() {
        return Stream.of(
                Arguments.of(LotteryRanks.FIRST_PRIZE, 0),
                Arguments.of(LotteryRanks.SECOND_PRIZE, 1),
                Arguments.of(LotteryRanks.THIRD_PRIZE, 2),
                Arguments.of(LotteryRanks.FOURTH_PRIZE, 3)
        );
    };


}

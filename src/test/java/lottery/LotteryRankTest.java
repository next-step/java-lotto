package lottery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryRankTest {

    @Test
    void getRank() {
        assertThat(LotteryRank.FIFTH.getMatchingCount()).isEqualTo(3);
        assertThat(LotteryRank.FIRST.getMatchingCount()).isEqualTo(6);
    }

    @Test
    void getPrize() {
        assertThat(LotteryRank.FIFTH.getPrize()).isEqualTo(5000);
        assertThat(LotteryRank.FIRST.getPrize()).isEqualTo(2000000000);
    }

    @ParameterizedTest
    @MethodSource("등수_판단_Provider")
    void 등수_판단(int matchingCount, boolean isBonusMatched, LotteryRank expectedRank) {
        assertThat(LotteryRank.valueOf(matchingCount, isBonusMatched)).isEqualTo(expectedRank);
    }

    static Stream<Arguments> 등수_판단_Provider() {
        return Stream.of(
                Arguments.of(0, true, LotteryRank.NONE),
                Arguments.of(0, false, LotteryRank.NONE),
                Arguments.of(1, true, LotteryRank.NONE),
                Arguments.of(1, false, LotteryRank.NONE),
                Arguments.of(2, true, LotteryRank.NONE),
                Arguments.of(2, false, LotteryRank.NONE),

                Arguments.of(3, true, LotteryRank.FIFTH),
                Arguments.of(3, false, LotteryRank.FIFTH),
                Arguments.of(4, true, LotteryRank.FOURTH),
                Arguments.of(4, false, LotteryRank.FOURTH),
                Arguments.of(6, true, LotteryRank.FIRST),
                Arguments.of(6, false, LotteryRank.FIRST),

                Arguments.of(5, true, LotteryRank.SECOND),
                Arguments.of(5, false, LotteryRank.THIRD)
        );
    }

}

package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryPrizeTest {
    private static Stream<Arguments> lotteryPrizeProvider() {
        return Stream.of(
                Arguments.of(0, true, LotteryPrize.NONE, false),
                Arguments.of(0, false, LotteryPrize.NONE, false),
                Arguments.of(1, true, LotteryPrize.NONE, false),
                Arguments.of(1, false, LotteryPrize.NONE, false),
                Arguments.of(2, true, LotteryPrize.NONE, false),
                Arguments.of(2, false, LotteryPrize.NONE, false),
                Arguments.of(3, true, LotteryPrize.FOURTH, false),
                Arguments.of(3, false, LotteryPrize.FOURTH, false),
                Arguments.of(4, true, LotteryPrize.THIRD, false),
                Arguments.of(4, false, LotteryPrize.THIRD, false),
                Arguments.of(5, true, LotteryPrize.SECOND_BONUS, true),
                Arguments.of(5, false, LotteryPrize.SECOND, false),
                Arguments.of(6, false, LotteryPrize.FIRST, false)
        );
    }

    @Test
    @DisplayName("LotteryPrize 생성")
    void create() {
        // given
        int matchingCount = 3;

        // when
        LotteryPrize lotteryPrize = LotteryPrize.FOURTH;

        // then
        assertThat(lotteryPrize).isNotNull();
        assertThat(lotteryPrize.calculateMatchingCount()).isEqualTo(matchingCount);
    }

    @ParameterizedTest(name = "{0}개 일치, 보너스 볼 일치 여부: {1}")
    @MethodSource("lotteryPrizeProvider")
    @DisplayName("valueOf 테스트")
    void valueOf(int matchingCount, boolean bonusMatch, LotteryPrize expected, boolean expectedBonusMatch) {
        // when
        LotteryPrize lotteryPrize = LotteryPrize.valueOf(matchingCount, bonusMatch);

        // then
        assertThat(lotteryPrize).isEqualTo(expected);
        assertThat(lotteryPrize.IsBonusMatched()).isEqualTo(expectedBonusMatch);
    }
}
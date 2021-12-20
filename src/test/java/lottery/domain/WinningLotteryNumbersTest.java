package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLotteryNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("로또 당첨 번호 중와 보너스 번호가 중복될 수 없음을 확인")
    void duplicatedBonusNumber(int bonusNumber) {
        LotteryTicket lotteryTicket = LotteryTicket.from(Lists.list(1, 2, 3, 4, 5, 6));

        assertThatIllegalArgumentException()
            .isThrownBy(() -> WinningLotteryNumbers.of(lotteryTicket, LotteryNumber.from(bonusNumber)));
    }

    @ParameterizedTest
    @MethodSource("testArgs")
    @DisplayName("당첨 복권과 일반 복권을 비교하여 적절한 Rank 값을 반환하는지 확인")
    void matchedRank(LotteryTicket lotteryTicket, Rank expectedRank) {
        final LotteryTicket winningLotteryTicket = LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LotteryNumber bonusNumber = LotteryNumber.from(7);
        final WinningLotteryNumbers winningLotteryNumbers = WinningLotteryNumbers.of(winningLotteryTicket, bonusNumber);

        assertThat(winningLotteryNumbers.matchedRank(lotteryTicket)).isEqualTo(expectedRank);
    }

    static Stream<Arguments> testArgs() {
        return Stream.of(
            Arguments.arguments(LotteryTicket.from(Arrays.asList(8, 9, 10, 11, 12, 13)), Rank.MISS),
            Arguments.arguments(LotteryTicket.from(Arrays.asList(1, 8, 9, 10, 11, 12)), Rank.MISS),
            Arguments.arguments(LotteryTicket.from(Arrays.asList(1, 2, 8, 9, 10, 11)), Rank.MISS),
            Arguments.arguments(LotteryTicket.from(Arrays.asList(1, 2, 3, 8, 9, 10)), Rank.FIFTH),
            Arguments.arguments(LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 8, 9)), Rank.FOURTH),
            Arguments.arguments(LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 5, 8)), Rank.THIRD),
            Arguments.arguments(LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 5, 7)), Rank.SECOND),
            Arguments.arguments(LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6)), Rank.FIRST),

            Arguments.arguments(LotteryTicket.from(Arrays.asList(8, 9, 10, 11, 12, 7)), Rank.MISS),
            Arguments.arguments(LotteryTicket.from(Arrays.asList(1, 8, 9, 10, 11, 7)), Rank.MISS),
            Arguments.arguments(LotteryTicket.from(Arrays.asList(1, 2, 8, 9, 10, 7)), Rank.MISS),
            Arguments.arguments(LotteryTicket.from(Arrays.asList(1, 2, 3, 8, 9, 7)), Rank.FIFTH),
            Arguments.arguments(LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 8, 7)), Rank.FOURTH)
        );
    }
}

package dev.dahye.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Rank 테스트")
class RankTest {
    @ParameterizedTest(name = "일치 횟수 = {0}, 보너스볼 {1}, 결과 = {2}")
    @MethodSource("ranks")
    @DisplayName("당첨된 횟수가 상금을 받을 수 있는 경우 valueOf() 을 호출하면 Rank 값 return")
    void valueOf_success(int matchCount, boolean isMatchBonusBall, Rank expectedRank) {
        assertThat(Rank.valueOf(matchCount, isMatchBonusBall)).isEqualByComparingTo(expectedRank);
    }

    private static Stream<Arguments> ranks() {
        return Stream.of(
                arguments(3, false, Rank.FIFTH),
                arguments(4, false, Rank.FOURTH),
                arguments(5, false, Rank.THIRD),
                arguments(5, true, Rank.SECOND),
                arguments(6, false, Rank.FIRST)
        );
    }

    @ParameterizedTest(name = "일치 횟수 = {0}, 보너스볼 {1}")
    @MethodSource("invalidRanks")
    @DisplayName("정의된 당첨 횟수가 아닌 경우 valueOf() 메서드를 호출하면 NO_RANK를 반환한다.")
    void valueOf_fail(int matchCount, boolean isMatchBonusBall) {
        assertThat(Rank.valueOf(matchCount, isMatchBonusBall)).isEqualTo(Rank.NO_RANK);
    }

    private static Stream<Arguments> invalidRanks() {
        return Stream.of(
                arguments(1, true),
                arguments(1, false),
                arguments(3, true),
                arguments(4, true),
                arguments(6, true),
                arguments(7, false),
                arguments(7, true)
        );
    }
}
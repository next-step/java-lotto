package dev.dahye.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Winning 테스트")
class WinningTest {
    @ParameterizedTest(name = "입력 값 = {0}")
    @MethodSource("winnings")
    @DisplayName("당첨된 횟수가 상금을 받을 수 있는 경우 getWinning 을 호출하면 Winning 값 return")
    void getWinning_success(int matchCount, Winning expectedWinning) {
        assertThat(Winning.getWinning(matchCount)).isEqualByComparingTo(expectedWinning);
    }

    private static Stream<Arguments> winnings() {
        return Stream.of(
                arguments(3, Winning.FOURTH),
                arguments(4, Winning.THIRD),
                arguments(5, Winning.SECOND),
                arguments(6, Winning.FIRST)
        );
    }

    @ParameterizedTest(name = "일치 횟수 = {0}")
    @ValueSource(ints = {0, 1, 2, 7, 8, 9})
    @DisplayName("정의된 당첨 횟수가 아닌 경우 getWinning 메서드를 호출하면 IllegalArgumentException throw")
    void getWinning_fail(int matchCount) {
        assertThrows(IllegalArgumentException.class, () -> Winning.getWinning(matchCount));
    }

    @ParameterizedTest(name = "일치 횟수 = {0}")
    @ValueSource(ints = {0, 1, 2, 7, 8, 9})
    @DisplayName("일치된 횟수가 상금을 수여할 수 없는 경우 isWinning(matchCount)는 false를 반환한다.")
    void getWinning_false(int matchCount) {
        assertThat(Winning.isWinning(matchCount)).isFalse();
    }
}
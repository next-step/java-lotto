package dev.dahye.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Winning 테스트")
class WinningTest {
    @ParameterizedTest(name = "입력 값 = {0}")
    @MethodSource("winnings")
    @DisplayName("당첨된 횟수가 상금을 받을 수 있는 경우")
    void winnings_success(int matchCount, Winning expectedWinning) {
        assertThat(Winning.getWinning(matchCount)).isEqualByComparingTo(expectedWinning);
    }

    private static Stream<Arguments> winnings() {
        return Stream.of(
                arguments(3, Winning.FOURTH),
                arguments(4, Winning.THIRD)
        );
    }

    @Test
    @DisplayName("당첨된 횟수가 상금을 받을 수 없는 경우 IllegalArgumentException throw")
    void winnings_fail() {
        assertThrows(IllegalArgumentException.class, () -> Winning.getWinning(0));
    }

    @Test
    @DisplayName("isWinning() 메서트 테스트")
    void isWinning() {
        int matchCount = 0;
        assertThat(Winning.isWinning(matchCount++)).isFalse();
        assertThat(Winning.isWinning(matchCount++)).isFalse();
        assertThat(Winning.isWinning(matchCount++)).isFalse();
        assertThat(Winning.isWinning(matchCount++)).isTrue();
        assertThat(Winning.isWinning(matchCount++)).isTrue();
        assertThat(Winning.isWinning(matchCount++)).isTrue();
        assertThat(Winning.isWinning(matchCount++)).isTrue();
        assertThat(Winning.isWinning(matchCount++)).isFalse();
    }
}
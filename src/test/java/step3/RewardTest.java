package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import step3.model.Reward;

@DisplayName("Reward 클래스 테스트")
public class RewardTest {

    @DisplayName("of 메서드 테스트")
    @ParameterizedTest(name = "[{index}] matchCount = {0}, isBonusMatch = {1}")
    @MethodSource("ofMethodSource")
    void of(int matchCount, boolean isBonusMatch, Reward reward) {
        assertThat(Reward.of(matchCount, isBonusMatch)).isEqualTo(reward);
    }

    private static Stream<Arguments> ofMethodSource() {
        return Stream.of(
            Arguments.of(6, false, Reward.FIRST),
            Arguments.of(5, true, Reward.SECOND),
            Arguments.of(5, false, Reward.THIRD),
            Arguments.of(4, true, Reward.FOURTH),
            Arguments.of(3, true, Reward.FIFTH),
            Arguments.of(2, true, Reward.BANG)
        );
    }

    @DisplayName("isWin 메서드 테스트")
    @ParameterizedTest(name = "[{index}] reward = {0}, isWin = {1}")
    @MethodSource("isWinMethodSource")
    void isWin(Reward reward, boolean isWin) {
        assertEquals(isWin, reward.isWin());
    }

    private static Stream<Arguments> isWinMethodSource() {
        return Stream.of(
            Arguments.of(Reward.FIRST, true),
            Arguments.of(Reward.SECOND, true),
            Arguments.of(Reward.THIRD, true),
            Arguments.of(Reward.FOURTH, true),
            Arguments.of(Reward.FIFTH, true),
            Arguments.of(Reward.BANG, false)
        );
    }
}

package lotto.domain;

import lotto.domain.winning.WinningReward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.winning.WinningReward.FIVE;
import static lotto.domain.winning.WinningReward.FIVE_WITH_BONUS;
import static lotto.domain.winning.WinningReward.FOUR;
import static lotto.domain.winning.WinningReward.SIX;
import static lotto.domain.winning.WinningReward.THREE;
import static lotto.domain.winning.WinningReward.ZERO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("당첨 보상 테스트")
public class WinningRewardTest {
    @DisplayName("숫자 일치한 개수로 당첨 보상 enum 가져오기")
    @ParameterizedTest
    @MethodSource("getWinningCount")
    public void getWinningReward(int winningCount, boolean matchBonusNumber, WinningReward expetedWinningReward) {
        WinningReward winningReward = WinningReward.findWinningCount(winningCount, matchBonusNumber);

        assertThat(winningReward).isEqualTo(expetedWinningReward);
    }

    static Stream<Arguments> getWinningCount() {
        return Stream.of(
                arguments(3, false, THREE),
                arguments(4, false, FOUR),
                arguments(5, false, FIVE),
                arguments(5, true, FIVE_WITH_BONUS),
                arguments(6, false, SIX),
                arguments(1, false, ZERO),
                arguments(2, false, ZERO),
                arguments(0, false, ZERO),
                arguments(7, false, ZERO)
        );
    }
}
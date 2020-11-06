package lotto.domain;

import lotto.domain.exception.InvalidWinningCountException;
import lotto.domain.winning.WinningReward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("당첨 보상 테스트")
public class WinningRewardTest {
    @DisplayName("잘못된 당첨 숫자 개수로 보상 조회")
    @ParameterizedTest
    @MethodSource("getInvalidWinningCount")
    public void getWinningRewardWithInvalidWinningCount(int invalidWinningCount) {
        assertThatThrownBy(() -> {
            WinningReward.getWinningPrice(invalidWinningCount);
        }).isInstanceOf(InvalidWinningCountException.class)
                .hasMessageContaining("잘못된 당첨 숫자 개수입니다.");
    }

    static Stream<Integer> getInvalidWinningCount() {
        return Stream.of(-1, 0, 1, 2, 7);
    }
}
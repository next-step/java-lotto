package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class WinningEnumTest {
    @DisplayName("당첨개수에 해당하는 당첨 금액을 리턴")
    @Test
    void 당첨_금액() {
        int correctCount = 3;
        int expectedWinningAmount = 5000;

        Optional<Integer> result = WinningEnum.winningAmount(correctCount);

        assertThat(result).isPresent();
        assertThat(result).hasValue(expectedWinningAmount);
    }

    @DisplayName("enum에 유효하지 않은 값을 전달할경우")
    @Test
    void 유효하지않은_값() {
        int correctCount = 9;

        Optional<Integer> result = WinningEnum.winningAmount(correctCount);

        assertThat(result).isEmpty();
    }
}
package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningCountTest {

    @DisplayName("WinningCount의 수를 증가")
    @Test
    void increase() {
        WinningCount winningCount = WinningCount.of();

        winningCount.increase();

        assertThat(winningCount.getValue()).isEqualTo(1);
    }

    @DisplayName("WinningCount에 money를 넣어 상금을 계산")
    @Test
    void calculateWinningMoney() {
        WinningCount winningCount = WinningCount.of(10);

        int result = winningCount.calculateWinningMoney(1000);

        assertThat(result).isEqualTo(10000);
    }
}

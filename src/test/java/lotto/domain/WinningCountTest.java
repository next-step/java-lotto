package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningCountTest {

    private WinningCount winningCount;

    @BeforeEach
    public void init() {
        // given
        winningCount = new WinningCount();

        // when
        winningCount.increaseCount(3);
        winningCount.increaseCount(3);
        winningCount.increaseCount(4);
    }

    @Test
    @DisplayName("당첨 결과 증가 테스트")
    public void increaseCountTest() {

        // when
        int matchCountOfThree = winningCount.getMatchCount(3);
        int matchCountOfFour = winningCount.getMatchCount(4);

        // then
        assertThat(matchCountOfThree).isEqualTo(2);
        assertThat(matchCountOfFour).isEqualTo(1);
    }

    @Test
    @DisplayName("총 당첨 상금 계산 테스트")
    public void calculatePrizeTest() {

        // when
        int prize = winningCount.calculatePrize();

        // then
        assertThat(prize).isEqualTo(60_000);
    }
}

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
        winningCount.increaseCount(Rank.FOURTH);
        winningCount.increaseCount(Rank.FIFTH);
        winningCount.increaseCount(Rank.FIFTH);
    }

    @Test
    @DisplayName("당첨 결과 증가 테스트")
    public void increaseCountTest() {

        // when
        int matchCountOfThree = winningCount.getMatchCount(Rank.FOURTH);
        int matchCountOfFour = winningCount.getMatchCount(Rank.FIFTH);

        // then
        assertThat(matchCountOfThree).isEqualTo(1);
        assertThat(matchCountOfFour).isEqualTo(2);
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

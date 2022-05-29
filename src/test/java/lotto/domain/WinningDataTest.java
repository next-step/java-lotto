package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningDataTest {
    private WinningData winningData;
    private LotteryGame lotteryGame;

    @BeforeEach
    void setup() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        winningData = new WinningData(winningNumbers, 7);

        List<Integer> lotteries = Arrays.asList(1,2,3,4,5,6);
        lotteryGame = new LotteryGame(lotteries);
    }

    @DisplayName("로또 번호 맞춘 갯수에 따라 등수 출력")
    @Test
    void matchNumbers() {
        assertThat(winningData.matchNumbers(lotteryGame)).isEqualTo(Rank.FIRST);
    }
}
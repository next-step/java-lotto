package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {

    @Test
    void _1등_찾기() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9), 4);
        assertThat(winningNumbers.findRank(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)))).isEqualTo(Rank.ONE);
    }
    @Test
    void _2등_찾기() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9), 4);
        assertThat(winningNumbers.findRank(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 4)))).isEqualTo(Rank.TWO);
    }
    @Test
    void _3등_찾기() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9), 4);
        assertThat(winningNumbers.findRank(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 0)))).isEqualTo(Rank.THREE);
    }
    @Test
    void _4등_찾기() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9), 4);
        assertThat(winningNumbers.findRank(new Lotto(Arrays.asList(1, 2, 3, 7, 0, 0)))).isEqualTo(Rank.FOUR);
    }
    @Test
    void _5등_찾기() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9), 4);
        assertThat(winningNumbers.findRank(new Lotto(Arrays.asList(1, 2, 3, 0, 0, 0)))).isEqualTo(Rank.FIVE);
    }

}
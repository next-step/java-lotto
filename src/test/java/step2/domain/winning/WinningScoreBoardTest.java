package step2.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningScoreBoardTest {

    @DisplayName("WinningScoreBoard 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // then
        Map<WinningScore, Integer> testMap = new HashMap<>();

        // when
        WinningScoreBoard winningScoreBoard = WinningScoreBoard.newInstance(testMap);

        // then
        assertThat(winningScoreBoard).isNotNull();
    }


    @DisplayName("WinningScoreBoard 인스턴스가 소유한 map의 값 반환 테스트")
    @Test
    void 값_반환() {
        // then
        Map<WinningScore, Integer> testMap = new HashMap<>();
        int expected = 0;

        // when
        WinningScoreBoard winningScoreBoard = WinningScoreBoard.newInstance(testMap);

        // then
        assertAll(
                () -> assertThat(winningScoreBoard.get(WinningScore.MISS)).isEqualTo(expected),
                () -> assertThat(winningScoreBoard.get(WinningScore.THREE)).isEqualTo(expected),
                () -> assertThat(winningScoreBoard.get(WinningScore.FOUR)).isEqualTo(expected),
                () -> assertThat(winningScoreBoard.get(WinningScore.FIVE)).isEqualTo(expected),
                () -> assertThat(winningScoreBoard.get(WinningScore.SIX)).isEqualTo(expected)
        );
    }

    @DisplayName("WinningScoreBoard 인스턴스가 소유한 map의 값 증가 테스트")
    @Test
    void 값_증가() {
        // then
        Map<WinningScore, Integer> testMap = new HashMap<>();
        int expected = 1;

        // when
        WinningScoreBoard winningScoreBoard = WinningScoreBoard.newInstance(testMap);
        winningScoreBoard.increaseCount(WinningScore.MISS);
        winningScoreBoard.increaseCount(WinningScore.THREE);
        winningScoreBoard.increaseCount(WinningScore.FOUR);
        winningScoreBoard.increaseCount(WinningScore.FIVE);
        winningScoreBoard.increaseCount(WinningScore.SIX);

        // then
        assertAll(
                () -> assertThat(winningScoreBoard.get(WinningScore.MISS)).isEqualTo(expected),
                () -> assertThat(winningScoreBoard.get(WinningScore.THREE)).isEqualTo(expected),
                () -> assertThat(winningScoreBoard.get(WinningScore.FOUR)).isEqualTo(expected),
                () -> assertThat(winningScoreBoard.get(WinningScore.FIVE)).isEqualTo(expected),
                () -> assertThat(winningScoreBoard.get(WinningScore.SIX)).isEqualTo(expected)
        );
    }

    @DisplayName("WinningScoreBoard 인스턴스가 총 수익률을 반환하는지 테스트")
    @Test
    void 반환_수익률() {
        // then
        Map<WinningScore, Integer> testMap = new HashMap<>();
        int inputMoney = 2_001_555_000;
        double expected = 1;

        // when
        WinningScoreBoard winningScoreBoard = WinningScoreBoard.newInstance(testMap);
        winningScoreBoard.increaseCount(WinningScore.MISS);
        winningScoreBoard.increaseCount(WinningScore.THREE);
        winningScoreBoard.increaseCount(WinningScore.FOUR);
        winningScoreBoard.increaseCount(WinningScore.FIVE);
        winningScoreBoard.increaseCount(WinningScore.SIX);

        double actual = winningScoreBoard.getYield(inputMoney);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
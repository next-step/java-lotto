package step2.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {

    @DisplayName("WinningResult 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // then
        Map<WinningScore, Integer> testMap = new HashMap<>();

        // when
        WinningResult winningResult = WinningResult.of(testMap);

        // then
        assertThat(winningResult).isNotNull();
    }


    @DisplayName("WinningResult 인스턴스가 소유한 map의 값 반환 테스트")
    @Test
    void 값_반환() {
        // then
        Map<WinningScore, Integer> testMap = new HashMap<>();
        int expected = 0;

        // when
        WinningResult winningResult = WinningResult.of(testMap);

        // then
        assertAll(
                () -> assertThat(winningResult.getMatchCount(WinningScore.MISS)).isEqualTo(expected),
                () -> assertThat(winningResult.getMatchCount(WinningScore.THREE)).isEqualTo(expected),
                () -> assertThat(winningResult.getMatchCount(WinningScore.FOUR)).isEqualTo(expected),
                () -> assertThat(winningResult.getMatchCount(WinningScore.FIVE)).isEqualTo(expected),
                () -> assertThat(winningResult.getMatchCount(WinningScore.SIX)).isEqualTo(expected)
        );
    }

    @DisplayName("WinningResult 인스턴스가 소유한 map의 값 증가 테스트")
    @Test
    void 값_증가() {
        // then
        Map<WinningScore, Integer> testMap = new HashMap<>();
        int expected = 1;

        // when
        WinningResult winningResult = WinningResult.of(testMap);
        winningResult.increaseCount(WinningScore.MISS);
        winningResult.increaseCount(WinningScore.THREE);
        winningResult.increaseCount(WinningScore.FOUR);
        winningResult.increaseCount(WinningScore.FIVE);
        winningResult.increaseCount(WinningScore.SIX);

        // then
        assertAll(
                () -> assertThat(winningResult.getMatchCount(WinningScore.MISS)).isEqualTo(expected),
                () -> assertThat(winningResult.getMatchCount(WinningScore.THREE)).isEqualTo(expected),
                () -> assertThat(winningResult.getMatchCount(WinningScore.FOUR)).isEqualTo(expected),
                () -> assertThat(winningResult.getMatchCount(WinningScore.FIVE)).isEqualTo(expected),
                () -> assertThat(winningResult.getMatchCount(WinningScore.SIX)).isEqualTo(expected)
        );
    }


}
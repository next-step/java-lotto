package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    private WinningResult winningResult;
    private Map<Rank, Long> mockWinningResultMap;

    @BeforeEach
    void setUp() {
        mockWinningResultMap = initMap();
        winningResult = new WinningResult(mockWinningResultMap);
    }

    private Map<Rank, Long> initMap() {
        mockWinningResultMap = new HashMap<>();
        mockWinningResultMap.put(Rank.FOURTH, 1L);
        return mockWinningResultMap;
    }

    @Test
    @DisplayName("당첨 결과 맵 확인")
    void winningResult() {
        assertThat(winningResult.getWinningResult(Rank.FIRST)).isEqualTo(0);
        assertThat(winningResult.getWinningResult(Rank.SECOND)).isEqualTo(0);
        assertThat(winningResult.getWinningResult(Rank.THIRD)).isEqualTo(0);
        assertThat(winningResult.getWinningResult(Rank.FOURTH)).isEqualTo(1);
        assertThat(winningResult.getWinningResult(Rank.FIFTH)).isEqualTo(0);
        assertThat(winningResult.getWinningResult(Rank.MISS)).isEqualTo(0);
    }

}

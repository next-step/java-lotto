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
}
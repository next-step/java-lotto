package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningResultTest {

    @Test
    void 일등_테스트() {
        WinningResult winningResult = WinningResult.getResult(6, false);
        assertThat(winningResult).isEqualTo(WinningResult.FIRST);
    }

    @Test
    void 이등_테스트() {
        WinningResult winningResult = WinningResult.getResult(5, true);
        assertThat(winningResult).isEqualTo(WinningResult.SECOND);
    }

    @Test
    void 삼등_테스트() {
        WinningResult winningResult = WinningResult.getResult(5, false);
        assertThat(winningResult).isEqualTo(WinningResult.THIRD);
    }

    @Test
    void 사등_테스트() {
        WinningResult winningResult = WinningResult.getResult(4, false);
        assertThat(winningResult).isEqualTo(WinningResult.FOUR);
    }

    @Test
    void 오등_테스트() {
        WinningResult winningResult = WinningResult.getResult(3, false);
        assertThat(winningResult).isEqualTo(WinningResult.FIVE);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 1, 0})
    void 꽝_테스트(int matchingCount) {
        WinningResult winningResult = WinningResult.getResult(matchingCount, false);
        assertThat(winningResult).isEqualTo(WinningResult.NOTHING);
    }

    @Test
    void 당첨된_값들만_가져온다() {
        List<WinningResult> results = WinningResult.winningResults();
        assertThat(results.size()).isEqualTo(5);
    }
}

package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultsTest {

    private final WinningResults winningResults = new WinningResults(
            Arrays.asList(WinningType.SECOND, WinningType.SECOND, WinningType.FOURTH)
    );

    @Test
    @DisplayName("결과값 객체에서 winningType 갯수 세기 테스트")
    void count() {
        assertThat(winningResults.count(WinningType.SECOND)).isEqualTo(2);
        assertThat(winningResults.count(WinningType.FOURTH)).isEqualTo(1);
        assertThat(winningResults.count(WinningType.FIRST)).isEqualTo(0);
    }

    @Test
    @DisplayName("결과값 객체에서 총 상금 합계 구하기 테스트")
    void sumPrizes() {
        assertThat(winningResults.sumPrizes()).isEqualTo(Money.from(60_050_000L));
    }
}

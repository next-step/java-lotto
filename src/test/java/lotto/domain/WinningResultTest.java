package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    private final WinningResult winningResult = new WinningResult(
            Arrays.asList(WinningType.SECOND, WinningType.SECOND, WinningType.FOURTH)
    );

    @Test
    @DisplayName("결과값 객체에서 winningType 갯수 세기 테스트")
    void count() {
        assertThat(winningResult.count(WinningType.SECOND)).isEqualTo(2);
        assertThat(winningResult.count(WinningType.FOURTH)).isEqualTo(1);
        assertThat(winningResult.count(WinningType.FIRST)).isEqualTo(0);
    }

    @Test
    @DisplayName("결과값 객체에서 총 상금 합계 구하기 테스트")
    void sumPrizes() {
        assertThat(winningResult.sumPrizes()).isEqualTo(Money.from(3_005_000L));
    }
}

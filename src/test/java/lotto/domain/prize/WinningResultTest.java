package lotto.domain.prize;

import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class WinningResultTest {

    @Test
    void 생성_테스트() {
        assertThatCode(() -> WinningResult.create(Maps.newHashMap(1, 3)))
                .doesNotThrowAnyException();
    }

    @Test
    void 수익율을_계산한다() {
        int match = 3;
        int winningCount = 1;
        int purchaseAmount = 14000;
        double expectedRate = 0.35;

        WinningResult winningResult = WinningResult.create(Maps.newHashMap(match, winningCount));
        double winningRate = winningResult.calculateWinningRate(purchaseAmount);

        assertThat(winningRate).isEqualTo(expectedRate);

    }

}
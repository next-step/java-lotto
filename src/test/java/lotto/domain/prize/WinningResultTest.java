package lotto.domain.prize;

import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class WinningResultTest {

    @Test
    void 생성_테스트() {
        assertThatCode(() -> WinningResult.create(Maps.newHashMap(Rank.MISS, 3)))
                .doesNotThrowAnyException();
    }

    @Test
    void 수익율을_계산한다() {
        Rank rank = Rank.FIFTH;
        int winningCount = 1;
        int purchaseAmount = 14000;
        double expectedRate = 0.35;

        WinningResult winningResult = WinningResult.create(Maps.newHashMap(rank, winningCount));
        double winningRate = winningResult.calculateWinningRate(purchaseAmount);

        assertThat(winningRate).isEqualTo(expectedRate);

    }

}
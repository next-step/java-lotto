package lotto.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @Test
    void 당첨_금액과_갯수_합() {
        WinningResult winningResult = new WinningResult(Rank.THIRD, 3);
        BigDecimal result = winningResult.add(BigDecimal.valueOf(0));

        BigDecimal multiply = Rank.THIRD.getPrizeMoney().multiply(BigDecimal.valueOf(3));
        assertThat(result).isEqualTo(multiply);
    }

    @Test
    void increase() {
        WinningResult winningResult = new WinningResult(Rank.THIRD, 3);
        winningResult.increase();

        assertThat(winningResult.getCount()).isEqualTo(4);
    }

    @Test
    void PrizeMoney_같은지() {
        WinningResult winningResult = new WinningResult(Rank.SECOND, 3);
        assertThat(winningResult.isSame(Rank.SECOND)).isTrue();
    }
}

package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @Test
    public void 당첨결과_동등비교() {
        WinningResult winningResult = new WinningResult(Prize.FIRST, 1);

        assertThat(winningResult).isEqualTo(new WinningResult(Prize.FIRST, 1));
    }
}
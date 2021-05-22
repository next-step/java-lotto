package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottosTest {

    @DisplayName("일치 개수가 주어졌을때 개수 증가 확인")
    @Test
    void WinningLottoTest() {
        WinningLottos winningLottos = new WinningLottos();
        winningLottos.add(2);
        winningLottos.add(3);
        winningLottos.add(3);
        winningLottos.add(5);
        winningLottos.add(6);

        assertThat(winningLottos.prizeCount(3)).isEqualTo(2);
        assertThat(winningLottos.prizeCount(4)).isEqualTo(0);
        assertThat(winningLottos.prizeCount(5)).isEqualTo(1);
        assertThat(winningLottos.prizeCount(6)).isEqualTo(1);
    }
}

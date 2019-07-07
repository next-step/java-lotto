package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {
    @Test
    void createTest() {
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,4,5,6"), 7);
        assertThat(winningLotto.getBounsNumber()).isEqualTo(7);
        assertThat(winningLotto.getWinLotto().getLotto().size()).isEqualTo(6);
    }
}

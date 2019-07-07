package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {
    @Test
    void createTest() {
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,4,5,6"), LottoNumber.of(7));
        assertThat(winningLotto.getBounsNumber()).isEqualTo(LottoNumber.of(7));
        assertThat(winningLotto.getWinLotto().getLotto().size()).isEqualTo(6);
    }

    @Test
    void notContainsBounsNumBer() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(Lotto.of("1,2,3,4,5,6"), LottoNumber.of(6)));
    }
}

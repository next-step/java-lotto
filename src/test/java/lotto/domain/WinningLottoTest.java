package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    void 생성() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6");
        assertThat(winningLotto).isEqualTo(WinningLotto.of("1,2,3,4,5,6"));
    }

    @Test
    void 로또_번호_음수_검증() {
        assertThatThrownBy(() -> {
            WinningLotto.of("1,2,3,4,5,-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_숫자_아닌_문자_검증() {
        assertThatThrownBy(() -> {
            WinningLotto.of("1,2,3,4,5,a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_숫자_최대값_검증() {
        assertThatThrownBy(() -> {
            WinningLotto.of("1,2,3,4,5,46");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void match() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6");
        assertThat(winningLotto.matchLottos(Arrays.asList(Lotto.ofWinningLotto("1,2,3,4,5,6")))).contains(WinningLottoAmount.FIRST);
    }

    @Test
    void 로또_2등_테스트() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", 7);
        assertThat(winningLotto.matchLottos(Arrays.asList(Lotto.ofWinningLotto("1,2,3,4,5,7")))).contains(WinningLottoAmount.SECOND);
    }
}
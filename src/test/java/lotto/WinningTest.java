package lotto;


import lotto.type.Winning;
import lotto.util.LottoNumberUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class WinningTest {

    @Test
    void 타입_메소드체크() {
        Winning winning = Winning.FIRST;
        assertThat(Winning.findByWinning(6, false)).isEqualTo(winning);
    }

    @Test
    void 타입_예외체크() {
        assertThatThrownBy(() -> {
            Winning.findByWinning(4, true);
        }).isInstanceOf(IllegalArgumentException.class);

    }

}

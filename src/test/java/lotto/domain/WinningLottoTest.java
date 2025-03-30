package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    void 보너스_숫자_중복_예외() {
        assertThatThrownBy(() -> new WinningLotto(
                Lotto.from("1,2,3,4,5,6"),
                new Number(6)
        )).isInstanceOf(IllegalArgumentException.class);
    }
}

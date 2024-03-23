package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("당첨 번호가 입력된 로또를 생성할 수 있다.")
    @Test
    void from() {
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6), 14);
        assertThat(winningLotto).isEqualTo(new WinningLotto(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.from(14)));
    }
}

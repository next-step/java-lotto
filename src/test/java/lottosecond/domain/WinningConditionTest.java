package lottosecond.domain;

import lottosecond.domain.lotto.Lotto;
import lottosecond.domain.lotto.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningConditionTest {

    @DisplayName("입력받은 로또 번호와 동일한 값이면 안됩니다.")
    @Test
    void duplicateWinningNumber() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        // then
        Assertions.assertThatThrownBy(() -> new WinningCondition(winningLotto, LottoNumber.of(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지난 주 당첨 번호와 동일합니다.");
    }
}
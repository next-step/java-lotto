package lotto.domain.lotto.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class WinningNumberTest {

    @DisplayName("로또 번호를 인자로 받아 해당 로또가 SECOND 등수인지 확인한다.")
    @Test
    void isBonus() {
        // given
        LottoNumbers lotto = new LottoNumbers(Set.of(1, 2, 3, 4, 5, 45));
        WinningNumber winningNumber = new WinningNumber(Set.of(1, 2, 3, 4, 5, 6), 45);

        // when
        boolean result = winningNumber.containsBonus(lotto);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외를 발생시킨다.")
    @Test
    void validateBonusNumber() {
        assertThatThrownBy(() -> new WinningNumber(Set.of(1, 2, 3, 4, 5, 6), 6))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("보너스 번호는 당첨번호와 중복될 수 없습니다.");
    }
}
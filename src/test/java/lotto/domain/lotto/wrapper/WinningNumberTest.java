package lotto.domain.lotto.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class WinningNumberTest {

    @DisplayName("로또 번호를 인자로 받아 해당 로또가 BONUS 등수인지 확인한다.")
    @Test
    void isBonus() {
        // given
        LottoNumbers lotto = new LottoNumbers(Set.of(1, 5, 12, 21, 32, 45));
        WinningNumber winningNumber = new WinningNumber(Set.of(1, 5, 12, 21, 32, 43), 45);

        // when
        boolean result = winningNumber.isBonus(lotto);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("로또 번호를 인자로 받아 해당 로또가 SECOND 등수인지 확인한다.")
    @Test
    void isSecond() {
        // given
        LottoNumbers lotto = new LottoNumbers(Set.of(1, 5, 12, 21, 32, 42));
        WinningNumber winningNumber = new WinningNumber(Set.of(1, 5, 12, 21, 32, 43), 45);

        // when
        boolean result = winningNumber.isSecond(lotto);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("로또 번호를 인자로 받아 당첨 번호에 해당 번호가 존재하는 지 확인한다.")
    @Test
    void contains() {
        // given
        WinningNumber winningNumber = new WinningNumber(Set.of(1, 5, 12, 21, 32, 43), 45);
        LottoNumber lottoNumber = new LottoNumber(5);

        // when & then
        assertThat(winningNumber.contains(lottoNumber)).isTrue();
    }
}
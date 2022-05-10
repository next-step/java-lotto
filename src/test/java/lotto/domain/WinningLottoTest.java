package lotto.domain;

import lotto.exceptions.DuplicateLottoNumberException;
import lotto.pattern.TestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @Test
    @DisplayName("이번주 우승 로또 번호와, 보너스볼의 번호는 중복이 될 수 없다.")
    void winningLotto() {
        assertThatThrownBy(() -> new WinningLotto(new LottoTicket(new TestNumberGenerator().generateLottoNumbers()), new LottoNumber(6)))
                .isInstanceOf(DuplicateLottoNumberException.class);
    }
}

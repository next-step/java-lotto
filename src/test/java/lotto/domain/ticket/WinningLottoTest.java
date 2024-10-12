package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @DisplayName("로또의 번호가 당첨 번호와 일치하는지 확인할 수 있다.")
    @Test
    void matchWinningNumber() {
        LottoTicket winningTicket = LottoTicket.of(
                List.of(
                        LottoNumber.of(1), LottoNumber.of(2),
                        LottoNumber.of(3), LottoNumber.of(4),
                        LottoNumber.of(5), LottoNumber.of(6)
                )
        );
        WinningLotto winningLotto = WinningLotto.of(winningTicket);

        assertThat(winningLotto.winningMatch(LottoNumber.of(1))).isTrue();
        assertThat(winningLotto.winningMatch(LottoNumber.of(7))).isFalse();
    }
}

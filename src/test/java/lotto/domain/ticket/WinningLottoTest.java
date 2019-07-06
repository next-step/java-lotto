package lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningLottoTest {

    @Test
    @DisplayName("로또티켓의 당첨개수를 확인한다")
    void matchCount() {
        LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        WinningLotto winningLotto = WinningLotto.of(LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(45));
        assertThat(winningLotto.getMatchCount(lottoTicket)).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스번호가 존재하는지 확인한다")
    void existBonusNumber() {
        LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        WinningLotto winningLotto = WinningLotto.of(LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(6));
        assertTrue(winningLotto.matchBonusNumber(lottoTicket));
    }

    @Test
    @DisplayName("보너스번호가 존재하지 않는것을 확인한다")
    void notExistBonusNumber() {
        LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        WinningLotto winningLotto = WinningLotto.of(LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(45));
        assertFalse(winningLotto.matchBonusNumber(lottoTicket));
    }
}

package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.WinningLottoTicket;
import lotto.factory.LottoFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.LottoTestUtils.createLottoTicket;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningLottoTicketTest {

    @Test
    public void winningLottoTicket_정상() {
        WinningLottoTicket ticket = LottoFactory.createWinningLottoTicket("1,2,3,4,5,6", 7);
        assertThat(ticket.matchLottoNumbers(createLottoTicket(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
        assertThat(ticket.hasBonusMatch(createLottoTicket(List.of(1, 2, 3, 4, 5, 6)))).isFalse();
    }

    @Test
    public void winningLottoTicket_6개숫자() {
        assertThatThrownBy(() -> LottoFactory.createWinningLottoTicket("1,2,3,4,5,6,7", 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void winningLottoTicket_보너스숫자중복() {
        assertThatThrownBy(() -> LottoFactory.createWinningLottoTicket("1,2,3,4,5,6", 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void matchLottoNumbers() {
        WinningLottoTicket ticket = LottoFactory.createWinningLottoTicket("1,2,3,4,5,6", 7);
        assertThat(ticket.matchLottoNumbers(createLottoTicket(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
    }

    @Test
    void hasBonusMatch_false() {
        WinningLottoTicket ticket = LottoFactory.createWinningLottoTicket("1,2,3,4,5,6", 7);
        assertThat(ticket.hasBonusMatch(createLottoTicket(List.of(1, 2, 3, 4, 5, 6)))).isFalse();
    }

    @Test
    void hasBonusMatch_true() {
        WinningLottoTicket ticket = LottoFactory.createWinningLottoTicket("1,2,3,4,5,6", 7);
        assertThat(ticket.hasBonusMatch(createLottoTicket(List.of(1, 2, 3, 4, 5, 7)))).isTrue();
    }
}

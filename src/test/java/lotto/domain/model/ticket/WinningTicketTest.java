package lotto.domain.model.ticket;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.InvalidWinningTicketException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningTicketTest {

    @Test
    @DisplayName("보너스 볼이 당첨 번호 중에 있다.")
    void of_InvalidLottoTicketContainsLottoNumber() {
        LottoTicket winningTicket = LottoTicket.of("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = LottoNumber.of(6);
        assertThatThrownBy(() ->
                WinningTicket.of(winningTicket, bonusNumber))
                .isInstanceOf(InvalidWinningTicketException.class);
    }
}

package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓 숫자가 6개인지 테스트")
    void lotto_ticket_count_test() {
        LottoMachine.getInstance();
        assertThatCode(() -> new LottoTicket(LottoMachine.generateLottoNumber()))
                .doesNotThrowAnyException();
    }
}

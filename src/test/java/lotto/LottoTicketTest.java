package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @DisplayName("금액에 따른 로또 티켓 계산")
    @Test
    void lottoTicketBuyingTest() {
        LottoBuyingMachine machine = new LottoBuyingMachine();
        assertThat(machine.purchaseTicket("14000")).isEqualTo(14);
    }
}

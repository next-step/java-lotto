package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketTest {
    @DisplayName("입력한 금액만큼 로또를 구매")
    @Test
    public void 입력한_구입금액만큼_로또를_구매한다() {
        Ticket ticket1 = new Ticket(14000);
        assertThat(ticket1.getBuyCount()).isEqualTo(14);

        Ticket ticket2 = new Ticket(1500);
        assertThat(ticket2.getBuyCount()).isEqualTo(1);
    }

    @DisplayName("1000원 미만의 금액 입력 시 ERROR")
    @Test
    void 천원미만_금액_입력() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Ticket(500));
    }
}
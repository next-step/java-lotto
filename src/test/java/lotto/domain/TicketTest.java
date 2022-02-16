package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TicketTest {
    @DisplayName("입력한 금액만큼 로또를 구매")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "15000,15", "2500,2"})
    public void 입력한_구입금액만큼_로또를_구매한다(int money, int expected) {
        PurchaseTicket ticket = new PurchaseTicket(new Money(money));
        assertThat(ticket.getBuyTotalCount()).isEqualTo(expected);
    }

    @DisplayName("1000원 미만의 금액 입력 시 ERROR")
    @Test
    void 천원미만_금액_입력() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new PurchaseTicket(new Money(500)));
    }
}

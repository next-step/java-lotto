package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class TicketTest {
    @DisplayName("입력한 금액만큼 로또를 구매한다")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "15000,15", "2000,2"})
    public void 입력한_구입금액만큼_로또를_구매한다(int money, int expected) {
        Ticket ticket = new Ticket(money);
        assertThat(ticket.getBuyCount()).isEqualTo(expected);
    }

    @DisplayName("1000원 미만의 금액 입력 시 EXCEPTION이 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {50, 100, 500, 789})
    void 천원미만_금액_입력(int cash) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Ticket(cash));
    }

    @DisplayName("1000원 단위의 금액이 아닐 경우 EXCEPTION이 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1050, 1500, 10200, 1789})
    void 천원_단위가_아닌_금액_입력(int cash) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Ticket(cash));
    }
}

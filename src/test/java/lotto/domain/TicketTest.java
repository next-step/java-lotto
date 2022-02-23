package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketTest {
    @DisplayName("입력한 금액만큼 로또를 구매한다")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "15000,15", "2000,2"})
    public void 입력한_구입금액만큼_로또를_구매한다(int money, int expected) {
        Ticket ticket = Ticket.of(money, 0);
        assertThat(ticket.getAutoCount()).isEqualTo(expected);
    }

    @DisplayName("1000원 미만의 금액 입력 시 EXCEPTION이 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {50, 100, 500, 789})
    void 천원미만_금액_입력(int cash) {
        assertThatThrownBy(() -> Ticket.of(cash, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위의 금액이 아닐 경우 EXCEPTION이 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1050, 1500, 10200, 1789})
    void 천원_단위가_아닌_금액_입력(int cash) {
        assertThatThrownBy(() -> Ticket.of(cash, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동, 자동 로또 구매 개수를 계산한다")
    @ParameterizedTest
    @CsvSource(value = {"5000,2,3", "15000,10,5", "7000,1,6"})
    void 천원_단위가_아닌_금액_입력(int cash, int manualCount, int autoCount) {
        Ticket ticket = Ticket.of(cash, manualCount);
        
        assertThat(ticket.getAutoCount()).isEqualTo(autoCount);
        assertThat(ticket.getManualCount()).isEqualTo(manualCount);
    }

    @DisplayName("구매 금액보다 더 많은 수동 로또는 살 수 없다")
    @Test
    void 주어진_금액보다_많은_수동_로또_구매() {
        assertThatThrownBy(() -> Ticket.of(5000, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매할 수동 로또의 개수는 음수일 수 없다")
    @Test
    void 음수_입력() {
        assertThatThrownBy(() -> Ticket.of(5000, -1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

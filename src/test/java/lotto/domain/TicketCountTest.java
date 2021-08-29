package lotto.domain;

import lotto.generic.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TicketCountTest {
    @DisplayName("생성")
    @Test
    void create() {
        TicketCount ticketCount = new TicketCount(5);
        assertThat(ticketCount).isEqualTo(new TicketCount(5));
    }

    @DisplayName("티켓 Count 수량이 0보다 작을 경우 IllegalArgumentException 발생")
    @Test
    void create_ThrowsIllegalArgumentException_IfInputIsUnderZero() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new TicketCount(-1)
        );
    }

    @DisplayName("입력 값인 Money에 따라 티켓 수량을 계산해서 반환")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @CsvSource({"3000, 3", "14500, 14", "0, 0"})
    void calculate_ReturnTicketCount_InputIsMoney(int money, int expected) {
        TicketCount ticketCount = TicketCount.calculateTicketCount(Money.wons(money));
        assertThat(ticketCount).isEqualTo(new TicketCount(expected));
    }

    @DisplayName("티켓 수량 차감")
    @Test
    void minus() {
        TicketCount ticketCount = new TicketCount(10);
        ticketCount = ticketCount.minus(new TicketCount(3));
        assertThat(ticketCount).isEqualTo(new TicketCount(7));
    }
}

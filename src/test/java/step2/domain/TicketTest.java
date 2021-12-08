package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 0", "2, 1", "10, 9", "15, 14"})
    @DisplayName("티켓을 차감한 새로운 객체를 반환한다.")
    public void deductedTicket(int input, int expected) {
        assertThat(new Ticket(input).deductedTicket()).isEqualTo(new Ticket(expected));
    }

}

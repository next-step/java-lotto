package lotto.Model;

import calculator.Model.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketTest {
    @Test
    @DisplayName("ticket create 정상 확인")
    public void ticket_create() {
        List<Integer> inputData = Arrays.asList(1, 2, 3, 4, 5, 6);
        TicketNumber expected = new TicketNumber(inputData);

        Ticket ticket = new Ticket(expected);
        TicketNumber actual = ticket.numbers();
        assertThat(actual).isEqualTo(expected);
    }

}
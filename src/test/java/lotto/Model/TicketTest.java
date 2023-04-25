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
    @DisplayName("ticket 숫자 6개 초과 입력 시 return error")
    public void ticket_above_6() {
        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> new Ticket(actual))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("ticket 숫자 6개 미만 입력 시 return error")
    public void ticket_under_6() {
        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new Ticket(actual))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("ticket create 정상 확인")
    public void ticket_create() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);

        Ticket ticket = new Ticket(expected);
        List<Integer> actual = ticket.numbers();
        assertThat(actual).isEqualTo(expected);
    }

}
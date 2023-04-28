package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TicketNumberTest {
    @Test
    @DisplayName("ticketNumber 숫자 6개 초과 입력 시 return error")
    public void ticketNumber_size_above_6() {
        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> new TicketNumber(actual))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("ticketNumber 숫자 6개 미만 입력 시 return error")
    public void ticketNumber_size_under_6() {
        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new TicketNumber(actual))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("ticketNumber 숫자 0 입력 시 return error")
    public void ticketNumber_under_1() {
        List<Integer> actual = Arrays.asList(0, 1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new TicketNumber(actual))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("ticketNumber 45 이상 숫자 입력 시 return error")
    public void ticketNumber_under_45() {
        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5, 50);

        assertThatThrownBy(() -> new TicketNumber(actual))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("ticketNumber 정상적으로 숫자 입력 시 return normal")
    public void ticketNumber_normal() {
        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5, 6);
        TicketNumber ticketNumber = new TicketNumber(actual);
        List<Integer> expected = ticketNumber.numbers();

        assertThat(actual).isEqualTo(expected);
    }
}
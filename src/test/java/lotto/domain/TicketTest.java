package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TicketTest {
    @DisplayName("응모권마다 6개의 번호를 지정에 성공한다")
    @Test
    public void ticketValidate() {
        //given
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        String answer = "[1, 2, 3, 4, 5, 6]";
        //when
        Ticket ticket = new Ticket(input);
        //then
        assertThat(ticket.rendering()).isEqualTo(answer);
    }

    @DisplayName("응모권마다 지정된 숫자의 수가 6개 미만인 경우 실패한다")
    @Test
    public void ticketFailUnder() {
        //given
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        //when
        //then
        assertThatThrownBy(() -> {
            Ticket ticket = new Ticket(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("응모권마다 지정된 숫자의 수가 6개 초과인 경우 실패한다")
    @Test
    public void ticketFailOver() {
        //given
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7);
        //when
        //then
        assertThatThrownBy(() -> {
            Ticket ticket = new Ticket(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
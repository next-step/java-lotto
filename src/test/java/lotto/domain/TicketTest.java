package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TicketTest {
    @DisplayName("응모권마다 6개의 번호를 지정에 성공한다")
    @Test
    public void ticketValidate() {
        //given
        Set<Integer> input = Set.of(1, 2, 3, 4, 5, 6);
        String answer = "[1, 2, 3, 4, 5, 6]";
        //when
        Ticket ticket = new Ticket(input);
        //then
        assertThat(ticket.toString()).isEqualTo(answer);
    }

    @DisplayName("응모권마다 지정된 숫자의 수가 6개 미만인 경우 실패한다")
    @Test
    public void ticketFailUnder() {
        //given
        Set<Integer> input = Set.of(1, 2, 3, 4, 5);
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
        Set<Integer> input = Set.of(1, 2, 3, 4, 5, 6, 7);
        //when
        //then
        assertThatThrownBy(() -> {
            Ticket ticket = new Ticket(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열로 숫자를 입력받아 Ticket 을 생성한다")
    @Test
    public void constructorByString() {
        //given
        Ticket expect = new Ticket(Set.of(1, 2, 3, 4, 5, 6));
        //when
        Ticket actual = new Ticket("1, 2, 3, 4, 5, 6");
        //then
        assertThat(actual.toString()).as("Set<Int> 생성자와 String 생성자가 입력이 같다면 출력도 같다").isEqualTo(expect.toString());
    }
}
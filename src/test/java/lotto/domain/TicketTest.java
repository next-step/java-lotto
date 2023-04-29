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

    @DisplayName("문자열로 숫자를 입력받아 Ticket 을 생성하는 로직을 검증한다")
    @Test
    public void constructorByString() {
        //given
        Ticket expect = new Ticket(Set.of(1, 2, 3, 4, 5, 6));
        //when
        Ticket actual = new Ticket("1, 2, 3, 4, 5, 6");
        //then
        assertThat(actual.toString())
                .as("Set<Int> 생성자와 String 생성자가 입력이 같다면 출력도 같다")
                .isEqualTo(expect.toString());
    }

    @DisplayName("일치하는 number 의 숫자 갯수를 구하는 로직을 검증한다")
    @Test
    public void matchCount() {
        //given
        int expect = 4;
        //when
        Ticket ticketA = new Ticket(Set.of(1, 2, 3, 4, 5, 6));
        Ticket ticketB = new Ticket(Set.of(1, 2, 3, 4, 35, 36));
        //then
        assertThat(ticketA.countMatchNumbers(ticketB))
                .as("일치하는 Number 수를 검증한다")
                .isEqualTo(expect);
        assertThat(ticketB.countMatchNumbers(ticketA))
                .as("순서가 바뀌어도 일치한다")
                .isEqualTo(expect);
    }

    @DisplayName("당첨권 생성 기능을 검증한다")
    @Test
    public void winnerTest() {
        //given
        Ticket ticket = new Ticket(Set.of(2, 4, 6, 8, 16, 32));
        //when
        WinnerTicket winnerTicket = ticket.winnerTicket(1);
        //then
        assertThat(winnerTicket.ticketOnly().toString())
                .as("당첨권의 숫자와 Ticket 인스턴스의 숫자는 일치한다")
                .isEqualTo(ticket.toString());
    }
}
/*
테스트하기위한 Ticket 클래스 기능 정리
countMatchNumbers : 몇개 숫자가 일치하는지 알아내는 기능
WinnerTicket() : 위너티켓을 생성해주는 기능
countWinner(List<Ticket> challengeTickets, Prize prize) : 입력받은 리스트 티켓에, 입력받은 등수의 티켓이 몆장이 포함되어있는지 검증
 */
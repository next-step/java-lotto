package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {

    @Test
    @DisplayName("입력된 금액만큼 로또가 구입되는지 확인")
    void buyTicketsTest() {
        Ticket ticket = new Ticket(14000);
        assertThat(ticket.getGameCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 당첨 개수 확인")
    void checkLottoTest() {
        Ticket ticket = new Ticket(1000);
        Set<Integer> wholeSet = IntStream.rangeClosed(1, 45).boxed().collect(toSet());
        Set<Integer> noneSet = IntStream.rangeClosed(0, 0).boxed().collect(toSet());
        assertThat(ticket.checkWinningCount(wholeSet)).isEqualTo(new int[]{0, 0, 0, 0, 0, 0, 1});
        assertThat(ticket.checkWinningCount(noneSet)).isEqualTo(new int[]{1, 0, 0, 0, 0, 0, 0});

    }
}

package lotto.domains;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.enums.Prize;
import lotto.exceptions.EmptyTicketsException;

public class TicketsTest {

    private List<Ticket> ticketList = Arrays.asList(
        new Ticket("1,2,3,5,8,13"), // SIX
        new Ticket("1,2,3,5,8,21"), // BONUS
        new Ticket("1,2,3,5,13,45"), // FIVE
        new Ticket("1,2,3,5,44,45"), // FOUR
        new Ticket("1,2,3,43,44,45"), // THREE
        new Ticket("1,2,42,43,44,45"), // TWO
        new Ticket("1,41,42,43,44,45"), // ONE
        new Ticket("40,41,42,43,44,45") // ZERO
    );
    private Ticket winningTicket = new Ticket("1,2,3,5,8,13");
    private BonusNumber bonusNumber = new BonusNumber("21");
    private WinningNumbers winningNumbers = new WinningNumbers(winningTicket, bonusNumber);
    private Scores answer = new Scores();

    private Tickets tickets = new Tickets(ticketList);

    @BeforeEach
    void setUp() {
        for (Prize prize : Prize.values()) {
            answer.increase(prize);
        }
    }

    @DisplayName("티켓 수를 반환한다.")
    @Test
    void size() {
        assertThat(tickets.size()).isEqualTo(ticketList.size());
    }

    @DisplayName("당첨된 티켓 수를 센다.")
    @Test
    void countPrize() {
        assertThat(tickets.scores(winningNumbers).equals(answer)).isTrue();
    }

    @DisplayName("티켓 리스트가 null이면 에러 발생")
    @Test
    void guard_Null_ExceptionThrown() {
        assertThatExceptionOfType(EmptyTicketsException.class).isThrownBy(() -> {
            new Tickets(null);
        });
    }

    @DisplayName("티켓 리스트가 크기가 0이면 에러 발생")
    @Test
    void guard_Empty_ExceptionThrown() {
        assertThatExceptionOfType(EmptyTicketsException.class).isThrownBy(() -> {
            new Tickets(Collections.emptyList());
        });
    }
}

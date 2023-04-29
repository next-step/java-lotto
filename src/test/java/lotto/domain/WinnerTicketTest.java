package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

public class WinnerTicketTest {

    private WinnerTicket winnerTicket;

    @BeforeEach
    public void beforeEach() {
        winnerTicket = new WinnerTicket(new Ticket(Set.of(1, 2, 4, 8, 16, 32)), 33);
    }

    @DisplayName("보너스 숫자 여부를 판별한다")
    @Test
    public void includeBonus() {
        //given
        //when
        //then
        fail();
    }

    @DisplayName("당첨자의 숫자를 구하는 기능을 검증한다")
    @Test
    public void countWinner() {
        //given

        //when
        //then
        fail();
    }
}
package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinnerTicketTest {

    private WinnerTicket winnerTicketFixture;
    private List<Ticket> ticketsFixture;

    @BeforeEach
    public void beforeEach() {
        Ticket winner = new Ticket(Set.of(1, 2, 4, 8, 16, 32));
        winnerTicketFixture = winner.winnerTicket(new LottoNumber( 33));

        Ticket first = new Ticket(Set.of(1, 2, 4, 8, 16, 32));
        Ticket secondA = new Ticket(Set.of(1, 2, 4, 8, 16, 33));
        Ticket secondB = new Ticket(Set.of(1, 2, 4, 8, 32, 33));

        Ticket thirdA = new Ticket(Set.of(1, 2, 4, 8, 16, 40));
        Ticket thirdB = new Ticket(Set.of(1, 2, 4, 8, 16, 41));
        Ticket thirdC = new Ticket(Set.of(1, 2, 4, 8, 16, 42));

        Ticket fourthA = new Ticket(Set.of(1, 2, 33, 4, 35, 8));
        Ticket fourthB = new Ticket(Set.of(1, 2, 33, 4, 35, 8));
        Ticket fourthC = new Ticket(Set.of(1, 2, 33, 4, 35, 8));
        Ticket fourthD = new Ticket(Set.of(1, 2, 33, 4, 35, 8));

        Ticket fifthA = new Ticket(Set.of(1, 2, 4, 15, 26, 37));
        Ticket fifthB = new Ticket(Set.of(1, 2, 4, 25, 26, 17));
        Ticket fifthC = new Ticket(Set.of(1, 2, 4, 35, 36, 37));
        Ticket fifthD = new Ticket(Set.of(1, 2, 4, 25, 36, 27));
        Ticket fifthE = new Ticket(Set.of(1, 2, 4, 35, 26, 17));
        ticketsFixture = List.of(
                first,
                secondA, secondB,
                thirdA, thirdB, thirdC,
                fourthA, fourthB, fourthC, fourthD,
                fifthA, fifthB, fifthC, fifthD, fifthE
        );
    }

    @DisplayName("보너스 숫자 여부를 판별한다")
    @Test
    public void includeBonus() {
        //given
        Ticket ticketA = new Ticket(Set.of(1, 2, 4, 8, 16, 33));
        Ticket ticketB = new Ticket(Set.of(1, 2, 4, 8, 32, 33));
        Ticket ticketC = new Ticket(Set.of(1, 2, 4, 8, 16, 40));
        //when
        Boolean actualA = winnerTicketFixture.includeBonus(ticketA);
        Boolean actualB = winnerTicketFixture.includeBonus(ticketB);
        Boolean actualC = winnerTicketFixture.includeBonus(ticketC);
        //then
        assertAll("",
                () -> assertThat(actualA).as("보너스 숫자를 포함하고 있어야한다").isEqualTo(true),
                () -> assertThat(actualB).as("보너스 숫자를 포함하고 있어야한다").isEqualTo(true),
                () -> assertThat(actualC).as("보너스 숫자를 포함하지 않는다").isEqualTo(false)
        );
    }

    @DisplayName("당첨자의 숫자를 구하는 기능을 검증한다")
    @Test
    public void countWinner() {
        //given
        //when
        int actualFirst = winnerTicketFixture.countWinner(ticketsFixture, Prize.FIRST);
        int actualSecond = winnerTicketFixture.countWinner(ticketsFixture, Prize.SECOND);
        int actualThird = winnerTicketFixture.countWinner(ticketsFixture, Prize.THIRD);
        int actualFourth = winnerTicketFixture.countWinner(ticketsFixture, Prize.FOURTH);
        int actualFifth = winnerTicketFixture.countWinner(ticketsFixture, Prize.FIFTH);
        //then
        assertAll("",
                () -> assertThat(actualFirst).as("").isEqualTo(1),
                () -> assertThat(actualSecond).as("").isEqualTo(2),
                () -> assertThat(actualThird).as("").isEqualTo(3),
                () -> assertThat(actualFourth).as("").isEqualTo(4),
                () -> assertThat(actualFifth).as("").isEqualTo(5)
        );
    }
}
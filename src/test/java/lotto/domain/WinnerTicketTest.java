package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinnerTicketTest {

    private WinnerTicket winnerTicketFixture;
    private Ticket ticketFixture;

    @BeforeEach
    public void beforeEach() {
        ticketFixture = Ticket.of(Set.of(1, 2, 4, 8, 16, 32));
        winnerTicketFixture = new WinnerTicket(ticketFixture, (LottoNumber.of(33)));
    }

    @DisplayName("보너스 숫자 여부를 판별한다")
    @Test
    public void includeBonus() {
        //given
        Ticket ticketA = Ticket.of(Set.of(1, 2, 4, 8, 16, 33));
        Ticket ticketB = Ticket.of(Set.of(1, 2, 4, 8, 32, 33));
        Ticket ticketC = Ticket.of(Set.of(1, 2, 4, 8, 16, 40));
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

    @DisplayName("당첨 티켓 입력시 Prize 를 반환한다")
    @Test
    public void checkLucky() {
        //given
        Ticket first = Ticket.of(Set.of(1, 2, 4, 8, 16, 32));

        Ticket secondA = Ticket.of(Set.of(1, 2, 4, 8, 16, 33));
        Ticket secondB = Ticket.of(Set.of(1, 2, 4, 8, 32, 33));

        Ticket thirdA = Ticket.of(Set.of(1, 2, 4, 8, 16, 40));
        Ticket thirdB = Ticket.of(Set.of(1, 2, 4, 8, 16, 41));
        Ticket thirdC = Ticket.of(Set.of(1, 2, 4, 8, 16, 42));

        Ticket fourthA = Ticket.of(Set.of(1, 2, 33, 4, 35, 8));
        Ticket fourthB = Ticket.of(Set.of(1, 2, 33, 4, 35, 8));
        Ticket fourthC = Ticket.of(Set.of(1, 2, 33, 4, 35, 8));
        Ticket fourthD = Ticket.of(Set.of(1, 2, 33, 4, 35, 8));

        Ticket fifthA = Ticket.of(Set.of(1, 2, 4, 15, 26, 37));
        Ticket fifthB = Ticket.of(Set.of(1, 2, 4, 25, 26, 17));
        Ticket fifthC = Ticket.of(Set.of(1, 2, 4, 35, 36, 37));
        Ticket fifthD = Ticket.of(Set.of(1, 2, 4, 25, 36, 27));
        Ticket fifthE = Ticket.of(Set.of(1, 2, 4, 35, 26, 17));
        //when
        //then
        assertAll("당첨 티켓 입력시 Prize 를 반환해야 한다. 등수별로 해당 로직을 검증한다",
                () -> assertThat(winnerTicketFixture.checkLucky(first)).as("1등 티켓을 검증한다").isEqualTo(Prize.FIRST),

                () -> assertThat(winnerTicketFixture.checkLucky(secondA)).as("2등 티켓을 검증한다").isEqualTo(Prize.SECOND),
                () -> assertThat(winnerTicketFixture.checkLucky(secondB)).as("2등 티켓을 검증한다").isEqualTo(Prize.SECOND),

                () -> assertThat(winnerTicketFixture.checkLucky(thirdA)).as("3등 티켓을 검증한다").isEqualTo(Prize.THIRD),
                () -> assertThat(winnerTicketFixture.checkLucky(thirdB)).as("3등 티켓을 검증한다").isEqualTo(Prize.THIRD),
                () -> assertThat(winnerTicketFixture.checkLucky(thirdC)).as("3등 티켓을 검증한다").isEqualTo(Prize.THIRD),

                () -> assertThat(winnerTicketFixture.checkLucky(fourthA)).as("4등 티켓을 검증한다").isEqualTo(Prize.FOURTH),
                () -> assertThat(winnerTicketFixture.checkLucky(fourthB)).as("4등 티켓을 검증한다").isEqualTo(Prize.FOURTH),
                () -> assertThat(winnerTicketFixture.checkLucky(fourthC)).as("4등 티켓을 검증한다").isEqualTo(Prize.FOURTH),
                () -> assertThat(winnerTicketFixture.checkLucky(fourthD)).as("4등 티켓을 검증한다").isEqualTo(Prize.FOURTH),

                () -> assertThat(winnerTicketFixture.checkLucky(fifthA)).as("5등 티켓을 검증한다").isEqualTo(Prize.FIFTH),
                () -> assertThat(winnerTicketFixture.checkLucky(fifthB)).as("5등 티켓을 검증한다").isEqualTo(Prize.FIFTH),
                () -> assertThat(winnerTicketFixture.checkLucky(fifthC)).as("5등 티켓을 검증한다").isEqualTo(Prize.FIFTH),
                () -> assertThat(winnerTicketFixture.checkLucky(fifthD)).as("5등 티켓을 검증한다").isEqualTo(Prize.FIFTH),
                () -> assertThat(winnerTicketFixture.checkLucky(fifthE)).as("5등 티켓을 검증한다").isEqualTo(Prize.FIFTH)
        );
    }
}
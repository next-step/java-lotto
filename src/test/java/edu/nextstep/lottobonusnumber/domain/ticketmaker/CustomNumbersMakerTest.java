package edu.nextstep.lottobonusnumber.domain.ticketmaker;

import edu.nextstep.lottobonusnumber.domain.Ticket;
import edu.nextstep.lottobonusnumber.domain.ticketmaker.CustomNumbersMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomNumbersMakerTest {

    @Test
    @DisplayName("Custom Ticket 생성")
    void createCustomTicket() {
        // given
        String numbersOfString = "1, 2, 3, 4, 5, 6";

        // when
        Ticket ticket = Ticket.madeBy(new CustomNumbersMaker(numbersOfString));

        // then
        assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

}
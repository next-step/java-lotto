package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfTicketTest {

    @Test
    @DisplayName("티켓의 수 객체 생성")
    public void create() throws Exception {
        NumberOfTicket numberOfTicket = new NumberOfTicket(10);
        assertThat(numberOfTicket).isEqualTo(new NumberOfTicket(10));
    }
}

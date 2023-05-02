package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IssuerTest {
    private Issuer issuerFixture;

    @BeforeEach
    public void beforeEach() {
        issuerFixture = new Issuer();
    }

    @DisplayName("수량만큼 Ticket 이 발행된다")
    @Test
    public void issue() {
        //given
        int input = 77;
        //when
        issuerFixture.automaticIssue(input);
        //then
        assertThat(issuerFixture.issuedTickets().getTickets()).hasSize(input);
    }

    @DisplayName("Statics 클래스를 생성한다")
    @Test
    public void makeStatics() {
        //given
        //when
        issuerFixture.automaticIssue(10);
        Statics statics = issuerFixture.issuedTicketStatistics(new Ticket("1, 2, 3, 4, 5, 6").winnerTicket(new LottoNumber( 7)));
        //then
        assertNotNull(statics);
    }
}
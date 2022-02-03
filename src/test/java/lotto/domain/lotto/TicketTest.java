package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketTest {

    private static final int TEST_MATCHES = 5;
    private static final int TEST_BONUS_NUMBER = 40;
    private static final List<Integer> BASE_TICKET_NUMBERS = Arrays.asList(8, 21, 23, 41, 42, 43);
    private static final List<Integer> TEST_TICKET_NUMBERS = Arrays.asList(8, 21, 23, 41, 42, 45);


    private Ticket ticket;

    @BeforeEach
    void setUp() {
        ticket = new Ticket(new Numbers(BASE_TICKET_NUMBERS));
    }

    @DisplayName("번호 6개에 대한 테스트")
    @Test
    void testMatches() {
        assertThat(ticket.matches(TEST_TICKET_NUMBERS))
            .isEqualTo(TEST_MATCHES);
    }

    @DisplayName("보너스 일치 여부 테스트")
    @Test
    void testBonusMatches() {
        assertFalse(ticket.checkBonus(TEST_BONUS_NUMBER));
    }
}

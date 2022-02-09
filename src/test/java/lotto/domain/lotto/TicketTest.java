package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketTest {

    private static final int TEST_MATCHES = 5;
    private static final int TEST_BONUS_NUMBER = 40;
    private static final List<Integer> BASE_TICKET_NUMBERS = Arrays.asList(8, 21, 23, 41, 42, 43);
    private static final List<Integer> TEST_TICKET_NUMBERS = Arrays.asList(8, 21, 23, 41, 42, 45);

    private Ticket ticket;
    private List<Number> testTicketNumbers;

    @BeforeEach
    void setUp() {
        List<Number> baseTicketNumbers = BASE_TICKET_NUMBERS.stream()
            .map(Number::new)
            .collect(Collectors.toList());

        testTicketNumbers = TEST_TICKET_NUMBERS.stream()
            .map(Number::new)
            .collect(Collectors.toList());
        ticket = new Ticket(new Numbers(baseTicketNumbers));
    }

    @DisplayName("번호 6개에 대한 테스트")
    @Test
    void testMatches() {
        assertThat(ticket.matches(testTicketNumbers))
            .isEqualTo(TEST_MATCHES);
    }

    @DisplayName("보너스 일치 여부 테스트")
    @Test
    void testBonusMatches() {
        assertFalse(ticket.hasBonus(TEST_BONUS_NUMBER));
    }
}

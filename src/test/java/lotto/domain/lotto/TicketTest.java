package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketTest {

    private Ticket ticket1;
    private List<Number> ticket2;

    @BeforeEach
    void setUp() {
        ticket1 = new Ticket(
            new Numbers(getNumberList(8, 21, 23, 41, 42, 43))
        );
        ticket2 = getNumberList(8, 21, 23, 41, 42, 45);
    }

    @DisplayName("번호 6개에 대한 테스트")
    @Test
    void testMatches() {
        assertThat(ticket1.matches(ticket2))
            .isEqualTo(5);
    }

    @DisplayName("보너스 일치 여부 테스트")
    @Test
    void testBonusMatches() {
        assertFalse(ticket1.hasBonus(40));
    }

    private List<Number> getNumberList(Integer ...values) {
        return Stream.of(values)
            .map(Number::new)
            .collect(Collectors.toList());
    }
}

package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import lotto.domain.generator.LottoManualGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketTest {

    private Ticket ticket1;

    @BeforeEach
    void setUp() {
        ticket1 = new Ticket(
            new LottoManualGenerator(8, 21, 23, 41, 42, 43)
                .generateNumbers()
        );
    }

    @DisplayName("번호 6개에 대한 테스트")
    @Test
    void testMatches() {
        List<Number> ticket2 = new LottoManualGenerator(8, 21, 23, 41, 42, 45)
            .generateNumbers();

        assertThat(ticket1.matches(ticket2))
            .isEqualTo(5);
    }

    @DisplayName("보너스 일치 여부 테스트")
    @Test
    void testBonusMatches() {
        assertFalse(ticket1.hasBonus(new Number(40)));
    }

}

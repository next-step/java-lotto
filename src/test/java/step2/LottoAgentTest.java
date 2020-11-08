package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAgentTest {
    @DisplayName("돈을 받고 티켓과 거스름돈을 반환한다.")
    @Test
    void exchange() {
        LottoAgent lottoAgent = new LottoAgent();
        Object[] ticketAndChange = lottoAgent.exchange(1500);
        assertThat(ticketAndChange).isNotNull()
                .hasSize(2)
                .hasOnlyElementsOfTypes(LottoTickets.class, Integer.class);
    }
}

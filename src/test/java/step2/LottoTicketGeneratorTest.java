package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketGeneratorTest {

    @DisplayName("입력한 티켓 장수와 생성된 로또 티켓의 장수는 동일하다")
    @ValueSource(ints = {1, 20, 100})
    @ParameterizedTest
    void generate_TicketCount_LottoTickets(int ticketCount) {
        List<LottoTicket> lottoTickets = LottoTicketGenerator.generate(ticketCount);
        assertThat(lottoTickets).hasSize(ticketCount);
    }

    @DisplayName("입력한 티켓 장수가 1장보다 작으면 예외가 발생한다")
    @Test
    void generate_TicketCountZero_ExceptionThrown() {
        assertThatThrownBy(() -> LottoTicketGenerator.generate(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("티켓은 최소 1장부터 생성 할 수 있습니다.");

    }
}

package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketGeneratorTest {

    @DisplayName("getTicketCount() 메소드는 입력한 티켓 장수와 동일하다.")
    @ValueSource(ints = {1, 20, 100})
    @ParameterizedTest
    void generate_TicketCount_LottoTickets(int ticketCount) {
        LottoTickets lottoTickets = LottoTicketGenerator.generate(ticketCount);
        assertThat(lottoTickets.getTicketCount()).isEqualTo(ticketCount);
    }

    @DisplayName("generate() 메소드는 1보다 작은 수를 입력하면 예외를 발생한다")
    @Test
    void generate_TicketCountZero_ExceptionThrown() {
        assertThatThrownBy(() -> LottoTicketGenerator.generate(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("티켓은 최소 1장부터 생성 할 수 있습니다.");

    }
}

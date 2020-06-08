package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {

    @DisplayName("정적 생성자는 1보다 작은 수를 입력하면 예외 발생")
    @Test
    void generateExceptionThrown() {
        assertThatThrownBy(() -> LottoTicketGenerator.generate(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("티켓은 최소 1장부터 생성 할 수 있습니다.");
    }

    @DisplayName("입력한 티켓 개수와 생성된 로또의 개수는 동일")
    @ValueSource(ints = {1, 20, 100})
    @ParameterizedTest
    void generate(int ticketCount) {
        LottoTicket lottoTicket = LottoTicketGenerator.generate(ticketCount);
        assertThat(lottoTicket.getLottoCount()).isEqualTo(ticketCount);
    }
}

package lotto.ticket;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketManualGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoTicketManualGeneratorTest {

    @Test
    @DisplayName("로또 수동 생성기를 생성하는데 어떤 에러도 발생하지 않는다.")
    void 로또_수동_생성기_생성_테스트() {
        assertThatCode(() -> new LottoTicketManualGenerator()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 수동 번호를 생성하고 LottoTicket을 반환한다.")
    void 로또_수동_번호_생성_테스트() {
        LottoTicket lottoTicket = new LottoTicketManualGenerator().generate();
        assertThat(lottoTicket).isNotNull();
    }
}

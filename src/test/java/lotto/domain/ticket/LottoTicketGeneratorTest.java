package lotto.domain.ticket;

import lotto.domain.number.RandomLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketGeneratorTest {

    @DisplayName("구입 가능한 갯수만큼 로또 티켓을 생성한다.")
    @Test
    void generateLottoTicketsTest() {
        LottoTickets lottoTickets = LottoTicketGenerator.generateLottoTickets(10, new RandomLottoNumberGenerator());

        assertThat(lottoTickets.size()).isEqualTo(10);
    }

}

package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {

    @Test
    @DisplayName("로또 티켓 생성")
    void generateLottoTickets() {
        LottoTickets lottoTickets = new LottoTickets(5);

        //생성된 로또 티켓은 NULL이 될 수 없다.
        assertThat(lottoTickets).isNotNull();
    }
}

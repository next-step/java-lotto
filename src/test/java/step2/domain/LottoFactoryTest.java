package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoFactoryTest {

    @Test
    @DisplayName("로또 가격을 입력하면 갯수를 반환한다.")
    void create(){
        LottoFactory lottoTicket = new LottoFactory(14000);
        assertThat(lottoTicket.getLottoTicketCount()).isEqualTo(14);
    }
}

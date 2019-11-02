package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketText {

    @Test
    void 로또티켓_클래스생성(){
        LottoTicket lottoTicket = new LottoTicket();
        assertThat(lottoTicket).isEqualTo(new LottoTicket());
    }

}

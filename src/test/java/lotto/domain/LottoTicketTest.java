package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓 생성")
    public void create() throws Exception {
        LottoTicket lottoTicket = new LottoTicket(new LottoNumbers());
        assertThat(lottoTicket).isEqualTo(new LottoTicket(new LottoNumbers(lottoTicket.lottoNumbers())));
    }

    @Test
    @DisplayName("로또 티켓 한 장의 가격")
    public void price() throws Exception {
        //given
        LottoTicket lottoTicket = new LottoTicket(new LottoNumbers());

        //when
        int price = lottoTicket.price();

        //then
        assertThat(price).isEqualTo(1_000);
    }
}

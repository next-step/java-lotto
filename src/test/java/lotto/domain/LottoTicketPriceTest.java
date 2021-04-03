package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketPriceTest {

    @Test
    @DisplayName("로또 가격 객체 생성")
    public void create() throws Exception {
        LottoTicketPrice lottoTicketPrice = new LottoTicketPrice();
        assertThat(lottoTicketPrice.price()).isEqualTo(1_000);
    }

    @Test
    @DisplayName("구매금액에 따른 구매할 수 있는 로또 티켓 장수 구하기")
    public void divide() throws Exception {
        //given
        LottoTicketPrice lottoTicketPrice = new LottoTicketPrice();

        //when
        int numberOfTicket = lottoTicketPrice.divide(1000);

        //then
        assertThat(numberOfTicket).isEqualTo(1);
    }
}

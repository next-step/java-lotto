package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSellerTest {
    @Test
    void 입력받은_금액에_따라_구입하는_로또복권의_개수를_반환한다() {
        //Given
        LottoSeller lottoSeller = new LottoSeller();
        int inputMoney = 14000;

        //When
        int lottoTicketsToBuy = lottoSeller.countLottoTickets(inputMoney);

        //Then
        assertThat(lottoTicketsToBuy).isEqualTo(14);
    }
}

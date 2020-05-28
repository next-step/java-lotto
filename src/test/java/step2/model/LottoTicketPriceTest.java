package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LottoTicketPriceTest {

    @DisplayName("티켓 1장의 기본 가격은 1,000원이다")
    @Test
    void getDefault_void_Price1000() {
        LottoTicketPrice lottoTicketPrice = LottoTicketPrice.getDefault();

        assertThat(lottoTicketPrice).isEqualTo(LottoTicketPrice.PRICE_1000);
        assertThat(lottoTicketPrice.getPrice()).isEqualTo(1_000);
    }
}

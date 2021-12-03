package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class MyLottoTicketsTest {

    @Test
    void create() {
        assertThatCode(() -> new MyLottoTickets(new LottoPrice(9000)))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 지불 가격에 따른 자동 번호 발급 기능")
    void buy() {
        LottoPrice lottoPrice = new LottoPrice(9000);
        MyLottoTickets myLottoTickets = new MyLottoTickets(lottoPrice);

        myLottoTickets.buy();

        assertThat(myLottoTickets.lottoTickets().size())
                .isEqualTo(9);
    }
}

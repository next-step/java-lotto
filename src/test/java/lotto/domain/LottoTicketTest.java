package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    void 자동_로또_여러개_생성() {

        LottoBuy lottoBuy = new LottoBuy(new Money("10000"));

        LottoTicket lottos = lottoBuy.buyAutoLottos(lottoBuy.getCount());

        assertThat(lottos.getLottoTicket().size()).isEqualTo(10);
    }
}
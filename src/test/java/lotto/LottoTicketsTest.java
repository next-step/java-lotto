package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


//- [ ] 구입 금액을 1000으로 나눈 갯수반큼 로또 티켓을 발행한다.
//        - [ ] 1부터 45까지의 숫자 중 중복되지 않는 6개의 숫자를 무작위로 선택한다

public class LottoTicketsTest {
    @Test
    void 구입_금액으로_로또_티켓_생성() {
        int purchaseAmount = 5_000;

        LottoTickets tickets = LottoTickets.create(purchaseAmount);

        assertThat(tickets.size()).isEqualTo(5);
    }

    @Test
    void 모든_로또_티켓_조회() {
        int purchaseAmount = 3_000;

        LottoTickets tickets = LottoTickets.create(purchaseAmount);

        List<Lotto> lottos = tickets.getLottos();
        assertThat(lottos).hasSize(3);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }
}

package lotto.domain;

import lotto.domain.ticket.LottoTickets;
import lotto.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoStoreTest {

    @DisplayName("금액을 입력하면 구매한 로또티켓을 반환한다")
    @Test
    void buyTest() {
        //given
        LottoStore lottoStore = new LottoStore(new AutoLottoNumberGenerator());

        //when
        LottoTickets lottoTickets = lottoStore.buy(new Money(14000));

        //then
        assertThat(lottoTickets.count()).isEqualTo(14);
    }

}

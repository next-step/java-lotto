package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoStoreTest {

    @DisplayName("금액을 입력하면 구매한 로또티켓을 반환한다")
    @Test
    void buyTest() {
        LottoStore lottoStore = new LottoStore(new AutoLottoNumberGenerator());

        LottoTickets lottoTickets = lottoStore.buy(14000);

        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(14);
    }

}
package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    LottoStore lottoStore = new LottoStore();

    @DisplayName("돈을 받아 lotto티켓을 주는 테스트")
    @Test
    void buyLottoTickets() {
        assertThat(lottoStore.giveLottoTickets(new Money(14000)).size()).isEqualTo(14);
        assertThat(lottoStore.giveLottoTickets(new Money(13500)).size()).isEqualTo(13);
        assertThat(lottoStore.giveLottoTickets(new Money(1000)).size()).isEqualTo(1);
    }

    @DisplayName("로또티켓 가격 테스트")
    @Test
    void 로또티켓가격() {
        assertThat(lottoStore.calcInvestment(14)).isEqualTo(new Money(14000));
        assertThat(lottoStore.calcInvestment(1)).isEqualTo(new Money(1000));
    }
}

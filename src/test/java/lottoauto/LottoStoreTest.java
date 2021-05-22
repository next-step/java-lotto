package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    LottoStore lottoStore = new LottoStore();

    @DisplayName("돈을 지불하여 lotto티켓을 사는 테스트")
    @Test
    void buyLottoTickets() {
        assertThat(lottoStore.buyLottoTickets(14000).size()).isEqualTo(14);
        assertThat(lottoStore.buyLottoTickets(13500).size()).isEqualTo(13);
        assertThat(lottoStore.buyLottoTickets(1000).size()).isEqualTo(1);
    }

    @DisplayName("로또티켓 가격 테스트")
    @Test
    void 로또티켓가격() {
        assertThat(lottoStore.price()).isEqualTo(1000);
    }
}

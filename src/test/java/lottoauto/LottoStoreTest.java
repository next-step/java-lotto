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
        assertThat(lottoStore.giveLottoTickets(14000).size()).isEqualTo(14);
        assertThat(lottoStore.giveLottoTickets(13500).size()).isEqualTo(13);
        assertThat(lottoStore.giveLottoTickets(1000).size()).isEqualTo(1);
    }

    @DisplayName("로또티켓 가격 테스트")
    @Test
    void 로또티켓가격() {
        assertThat(lottoStore.price()).isEqualTo(1000);
    }
}

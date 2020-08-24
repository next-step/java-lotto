package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    private LottoStore lottoStore;
    private List<Integer> lottos;

    @BeforeEach
    void setUp() {
        lottos = LottoNumberGenerator.create();
    }

    @Test
    @DisplayName("구매한 로또 복권 개수 확인")
    void purchasedLottoTicket() {
        List<Integer> lottoNumber = LottoNumberGenerator.getLottoNumbers(lottos);
        lottoStore = new LottoStore(lottoNumber, 5);
        assertThat(lottoStore.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("임의의 로또 티켓을 만드는 테스트")
    void createManualLottoTicket() {
        LottoStore lottoStore = new LottoStore(1, Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoStore.getLottoTicket(0).getLottoTicket()).contains(1,2,3,4,5,6);
    }

}

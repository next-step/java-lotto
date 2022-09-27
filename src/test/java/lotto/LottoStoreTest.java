package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoStoreTest {

    @Test
    void shouldBuyLotto(){
        LottoStore store = new LottoStore();
        assertThat(store.getLottoNum(14000)).isEqualTo(14);
    }

    @Test
    void shouldGetLotto(){
        LottoStore lottoStore = new LottoStore();
        assertThat(lottoStore.getLotto().getLotto().size()).isEqualTo(6);
    }

    @Test
    void shouldReturnLottoMatchedCount(){
        LottoStore store = new LottoStore();
        Lotto lotto = store.getLotto(List.of(1,2,3,4,5,6));
        assertThat(store.getMatchedCount(lotto, List.of(1,2,3,4,5,6))).isEqualTo(6);
    }
}
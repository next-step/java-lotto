package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    void shouldBuyLotto(){
        LottoStore store = new LottoStore(()->List.of(1,2,3,4,5,6));
        assertThat(store.getLottoNum(14000)).isEqualTo(14);
    }

    @Test
    void shouldGetLotto(){
        LottoStore store = new LottoStore(()->List.of(1,2,3,4,5,6));
        assertThat(store.buy(14000).getLottos().size()).isEqualTo(14L);
    }


}
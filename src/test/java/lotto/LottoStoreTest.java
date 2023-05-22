package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoStoreTest {

    @Test
    void 로또개수_체크() {
        LottoStore lottoStore = new LottoStore();
        assertThat(lottoStore.buyRandomLotto(9500).size()).isEqualTo(9);
        assertThat(lottoStore.buyRandomLotto(10000).size()).isEqualTo(10);
    }

    @Test
    void 수동로또_돈_부족시_에러체크() {
        LottoStore lottoStore = new LottoStore();
        List<String> lottos = new ArrayList<>();
        lottos.add("1,2,3,4,5,6");
        lottos.add("1,2,3,4,5,6");
        Assertions.assertThatThrownBy(()-> lottoStore.buyManualAndRandomLotto(1500,lottos)).isInstanceOf(IllegalArgumentException.class);
    }
}

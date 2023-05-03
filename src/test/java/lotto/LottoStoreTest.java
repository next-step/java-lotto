package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoStoreTest {

    @Test
    void 로또개수_체크() {
        LottoStore lottoStore = new LottoStore();
        assertThat(lottoStore.buyLotto(9500).size()).isEqualTo(9);
        assertThat(lottoStore.buyLotto(10000).size()).isEqualTo(10);
    }
}

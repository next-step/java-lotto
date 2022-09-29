package lotto;

import lotto.service.LottoNumberPicker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    void shouldBuyLotto() {
        LottoStore store = new LottoStore(getLottoNumberPicker());
        assertThat(store.buy(14000).getSize()).isEqualTo(14);
    }

    private LottoNumberPicker getLottoNumberPicker() {
        return () -> List.of(1, 2, 3, 4, 5, 6);
    }

}

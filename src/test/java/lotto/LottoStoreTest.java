package lotto;

import lotto.model.LottoBall;
import lotto.service.LottoNumberPicker;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    void shouldBuyLotto() {
        LottoStore store = new LottoStore(getNumberPicker());

        assertThat(store.buy(14000,0).size()).isEqualTo(14);
    }

    @Test
    void shouldBuyLotto_whenManualLotto(){
        LottoStore store = new LottoStore(getNumberPicker());

        assertThat(store.buy(14000,3).size()).isEqualTo(11);
    }
    private LottoNumberPicker getNumberPicker() {
        return () -> List.of(1, 2, 3, 4, 5, 6).stream().map(LottoBall::new).collect(Collectors.toList());
    }

}

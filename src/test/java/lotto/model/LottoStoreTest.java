package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoStoreTest {

    @Test
    @DisplayName("수량에 따른 자동 구매")
    public void buyLottoTest() {
        Order order = new Order(2000, 1);
        Lottos handPickLottos = new Lottos();
        handPickLottos.add(new PickNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));

        LottoStore lottoStore = new LottoStore(order, handPickLottos);

        assertThat(lottoStore.buyAutoPick().getPickNumbers().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("수동 번호를 더 넣었을때 예외처리")
    public void moreNumberException() {
        Order order = new Order(2000, 0);
        Lottos handPickLottos = new Lottos();
        handPickLottos.add(new PickNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoStore(order, handPickLottos);
        });
    }
}

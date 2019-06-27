package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoStoreTest {

    private LottoNumbers numbers;

    @BeforeEach
    void setUp() {
        numbers = new LottoNumbers(
                Arrays.asList(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)
                )
        );
    }

    @Test
    @DisplayName("수량에 따른 자동 구매")
    public void buyLottoTest() {
        Order order = new Order(2000, 1);
        Lottos handPickLottos = new Lottos();
        handPickLottos.add(new PickNumbers(numbers));

        LottoStore lottoStore = new LottoStore(order, handPickLottos);

        assertThat(lottoStore.buyAutoPick().getPickNumbers().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("수동 번호를 더 넣었을때 예외처리")
    public void moreNumberException() {
        Order order = new Order(2000, 0);
        Lottos handPickLottos = new Lottos();
        handPickLottos.add(new PickNumbers(numbers));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoStore(order, handPickLottos);
        });
    }
}

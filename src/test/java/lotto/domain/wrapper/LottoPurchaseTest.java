package lotto.domain.wrapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoPurchaseTest {

    @Test
    void 예산으로_구매가능_자동구매_금액_Test() {
        int budget = 3000;
        LottoPurchase lottoPurchase = new LottoPurchase(budget);

        assertThat(lottoPurchase.countOfAvailableAutoLotto()).isEqualTo(3);
    }

    @Test
    void invalid_예산에서_입력된_수동로또_개수_유효성_Test() {
        int budget = 3000;

        assertThatThrownBy(() ->
                new LottoPurchase(budget, 4)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->
                new LottoPurchase(budget, -1)
        ).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 예산에서_수동로또_제외한_자동구매_가능_개수_Test() {
        int budget = 3000;
        LottoPurchase lottoPurchase = new LottoPurchase(budget, 1);

        assertThat(lottoPurchase.countOfAvailableAutoLotto()).isEqualTo(2);
    }
}

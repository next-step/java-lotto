package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @Test
    void 유효한_로또구매금액_Test() {
        LottoPurchaseBudget budget = new  LottoPurchaseBudget(1000);
        assertThat(budget.equals(new LottoPurchaseBudget(1000)));
    }

    @Test
    void 유효하지않은_로또구매금액_Test() {
        assertThatThrownBy(() -> new LottoPurchaseBudget(999))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoPurchaseBudget(900))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

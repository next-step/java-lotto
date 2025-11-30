package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoPurchasePlanTest {

    @Test
    @DisplayName("Lotto 개수는 구매 금액과 수동 개수로 정해진다.")
    void validLottoQuantity() {
        LottoPurchasePlan lottoPurchasePlan = new LottoPurchasePlan(new Money(3000), 2);
        assertThat(lottoPurchasePlan.totalCount()).isEqualTo(new Count(3));
        assertThat(lottoPurchasePlan.autoCount()).isEqualTo(new Count(1));
    }

    @Test
    @DisplayName("Lotto 개수가 음수이거나 구매 가능 개수를 넘어서면 예외가 발생한다.")
    void invalidLottoQuantity() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoPurchasePlan(new Money(3000), -1));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoPurchasePlan(new Money(3000), 10));
    }
}
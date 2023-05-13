package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoPurchaseAmountTest {
    @Test
    @DisplayName("주어진 금액으로 구매 가능한 로또 개수를 반환한다.")
    void 구매가능한_로또개수() {
        LottoPurchaseAmount amount = LottoPurchaseAmount.of(10000);
        assertThat(amount.calculateQuantity()).isEqualTo(10);
    }

    @Test
    @DisplayName("거스름돈이 발생하는 경우 예외를 던진다.")
    void 거스름돈_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoPurchaseAmount.of(1500);
        });
    }

    @Test
    @DisplayName("주어진 당첨금액에 대한 이익률을 계산한다.")
    void 이익률_계산() {
        LottoPurchaseAmount amount = LottoPurchaseAmount.of(1000);
        assertThat(amount.calculateProfitRate(10000)).isEqualTo(10.0);
    }
}

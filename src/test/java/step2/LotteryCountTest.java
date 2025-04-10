package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lottery.LotteryCount;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class LotteryCountTest {
    @Test
    @DisplayName("구매 금액이 음수일 때, 예외를 발생시킨다.")
    void negativePurchaseAmountTest() {
        assertThatThrownBy(() -> {
            LotteryCount purchaseAmount = new LotteryCount(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수 값이 입력되었습니다. 값 : -1");
    }

    @Test
    @DisplayName("구매 금액이 로또 한 장의 가격보다 작을 때, 예외를 발생시킨다.")
    void lessThanLottoPriceTest() {
        assertThatThrownBy(() -> {
            LotteryCount purchaseAmount = new LotteryCount(999);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 한 장의 가격보다 작은 금액입니다. 값 : 999");
    }

    @Test
    @DisplayName("구매 금액이 로또 한 장의 가격보다 클 때, 로또 개수를 반환한다.")
    void lottoCountTest() {
        LotteryCount purchaseAmount = new LotteryCount(1999);
        assertThat(purchaseAmount.getAutoLottoCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("구매 금액이 로또 한 장의 가격보다 클 때, 로또 개수를 반환한다.")
    void lottoCountTest2() {
        LotteryCount purchaseAmount = new LotteryCount(2000);
        assertThat(purchaseAmount.getAutoLottoCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("수동으로 구매한 금액은 제외하고, 실제 살 수 있는 로또 개수를 반환한다.")
    void lottoCountExceptManualTest() {
        LotteryCount purchaseAmount = new LotteryCount(2000, 1);
        assertThat(purchaseAmount.getAutoLottoCount()).isEqualTo(1);
    }
}

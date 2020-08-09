package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {
    @DisplayName("최소 로또 구매 금액이 아닌 경우 예외 발생")
    @Test
    public void lottoPriceTest() {
        // given
        int money = 500;
        int manualCount = 0;

        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(money, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 최소 구매 금액은 1000 원 입니다");
    }

    @DisplayName("1회 구매 한도금액을 초과한 경우 예외 발생")
    @Test
    public void purchaseLimitTest() {
        // given
        int money = 150000;
        int manualCount = 0;

        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(money, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 1회 한도 구매 금액은 100000 원 입니다");
    }

    @DisplayName("수동 구매하려는 복권 수가 구매금액을 초과한 경우 예외 발생")
    @Test
    public void manualCountTest() {
        // given
        int money = 5000;
        int manualCount = 10;

        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(money, manualCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 금액을 초과 하였습니다");
    }

    @DisplayName("자동 구매 복권 수가 올바르게 반환 되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "10000:0:10",
            "10000:5:5",
            "10000:10:0",
            "9500:5:4"
    }, delimiter = ':')
    public void getAutoCountOfPurchaseTest(int money, int manualCount, int expectedAutoCount) {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(money, manualCount);

        // when & then
        assertThat(purchaseAmount.getAutoCountOfPurchase()).isEqualTo(expectedAutoCount);
    }

    @DisplayName("수익률이 올바르게 계산되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "10000:5000:0.5",
            "10000:7500:0.75",
            "10000:10000:1",
            "10000:100000:10"
    }, delimiter = ':')
    public void getReturnOfInvestmentTest(int money, long reward, double expectedRoi) {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(money, 0);

        // when & then
        assertThat(purchaseAmount.getReturnOfInvestment(reward)).isEqualTo(expectedRoi);
    }
}
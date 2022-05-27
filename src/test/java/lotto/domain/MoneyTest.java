package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("Money 생성 테스트")
    @Test
    void createMoney() {
        assertThat(new Money(2000))
                .isEqualTo(new Money(2000));
    }

    @DisplayName("Money 생성 테스트 - 0보다 작은 금액을 생성하는 경우")
    @Test
    void createMoneyFail() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateProfitTest() {
        assertThat(new Money(2000).profitRate(new Money(20000)))
                .isEqualTo(0.1);
    }

    @DisplayName("수익률 계산 테스트 - 0원을 기준으로 수익률을 계산하는 경우")
    @Test
    void calculateProfitTestFail() {
        assertThatThrownBy(() -> new Money(2000).profitRate(new Money(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 계산할 금액을 제외한 금액을 반환한다.")
    @Test
    void excludeManualPurchaseTest() {
        assertThat(new Money(3000).excludeManualPurchase(2))
                .isEqualTo(new Money(1000));
    }

    @DisplayName("해당 금액으로 몇 개의 로또를 살 수 있는지 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"20000:20", "20100:20"}, delimiter = ':')
    void purchaseCountTest(int price, int count) {
        assertThat(new Money(price).purchaseCount())
                .isEqualTo(count);
    }
}

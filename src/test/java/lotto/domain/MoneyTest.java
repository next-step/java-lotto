package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
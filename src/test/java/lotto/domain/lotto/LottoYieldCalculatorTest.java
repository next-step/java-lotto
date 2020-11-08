package lotto.domain.lotto;

import lotto.domain.exception.InvalidMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("수익률 계산기 테스트")
public class LottoYieldCalculatorTest {
    @DisplayName("0원으로 수익률 계산")
    @Test
    public void getRevenueWithZeroMoney() {
        assertThatThrownBy(() -> {
            LottoYieldCalculator.calculateYield(100, 0);
        }).isInstanceOf(InvalidMoneyException.class)
                .hasMessageContaining("금액은 0보다 커야합니다.");
    }
}
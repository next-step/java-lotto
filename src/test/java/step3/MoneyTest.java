package step3;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.exception.MoneyRangeNegativeException;
import step3.model.Money;

public class MoneyTest {

    @DisplayName("예외 - 0 미만의 값으로 생성 불가")
    @Test
    void moneyRangeNegativeExceptionBecauseInputMoneyIsLessThan0() {
        long invalidMoney = -1L;
        assertThatThrownBy(() -> new Money(invalidMoney))
            .isInstanceOf(MoneyRangeNegativeException.class);
    }
    
}

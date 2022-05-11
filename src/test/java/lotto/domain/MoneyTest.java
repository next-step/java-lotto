package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("구매금액이 1000 단위가 아니면 예외가 발생한다")
    void moneyThousandsException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money("1001"))
                .withMessage("1,000원 단위로만 구매 가능합니다.");
    }

    @Test
    @DisplayName("숫자외의 문자열을 입력하면 예외가 발생한다")
    void wrongMoneyException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money("10oo"))
                .withMessage("숫자형식이 아닙니다.");
    }

    @Test
    void isPurchasable() {
    }

    @Test
    void getMaxPurchasableQuantity() {
    }

    @Test
    void getReturnRate() {
    }
}

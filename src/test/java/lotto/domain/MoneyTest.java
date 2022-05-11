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
    @DisplayName("구매금액 14000, 당첨금 5000 이면 수익률은 약 0.35이다")
    void calculateReturnRate() {
        Money money = new Money("14000", 14);
        assertThat(money.calculateReturnRate(5000)).isBetween(0.35, 0.36);
    }
}

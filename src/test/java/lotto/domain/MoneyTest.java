package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @Test
    @DisplayName("음수 이상의 정수를 입력하면 정상적으로 생성된다.")
    void createMoney() {
        int inputMoney = 1_000;

        assertThat(new Money(inputMoney)).isEqualTo(new Money(inputMoney));
    }

    @Test
    @DisplayName("음수를 입력하면 오류가 발생한다.")
    void createMoney_음수() {
        int inputMoney = -1;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(inputMoney))
                .withMessage("음수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("당첨금액이 3000이고 구임금액이 1000원이라면 수익률은 3.00이다.")
    void calcReturnRate() {
        Money totalWinningPrice = new Money(3_000);
        Money userMoney = new Money(1_000);

        assertThat(totalWinningPrice.calcReturnRate(userMoney)).isEqualTo(new BigDecimal("3.00"));
    }
}
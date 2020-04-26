package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @DisplayName("보유한 금액으로 구매 가능한 수 리턴")
    @Test
    void buyCount() {
        Money money = new Money(4000);
        assertThat(money.buyCount(1000)).isEqualTo(4);
    }

    @DisplayName("0원 미만 금액으로 생성시 에러")
    @Test
    void createError() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-1));
    }

}

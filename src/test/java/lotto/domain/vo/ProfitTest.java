package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitTest {

    @Test
    @DisplayName("이익률이 음수이면 예외를 던진다.")
    void createProfitTest() {
        assertThrows(IllegalArgumentException.class, () -> new Profit(-1.0));
    }

    @Test
    @DisplayName("사용 금액과 얻은 금액을 이용하여 이익률을 생성한다.")
    void createProfitWithMoneyTest() {
        //given
        Money dividend = new Money(1000L);
        Money divisor = new Money(20000L);

        //when, then
        assertThat(new Profit(dividend, divisor)).isEqualTo(new Profit(0.05));
    }
}
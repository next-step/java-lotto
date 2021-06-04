package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {

    @Test
    @DisplayName("수익률을 계산한다.")
    void profit_test() {
        //given
        Profit profit = new Profit(new Money(2000), 1_500_000);

        //then
        assertThat(profit).isEqualTo(new Profit(750.0));
    }
}

package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {

    @Test
    @DisplayName("수익률을 더한다.")
    void add_test() {
        //given
        Profit profit = new Profit();

        //when
        profit.add(10);

        //then
        assertThat(profit).isEqualTo(new Profit(10));
    }
}

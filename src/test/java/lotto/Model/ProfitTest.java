package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProfitTest {
    @Test
    @DisplayName("3,4,5,6이 아닌 숫자는 profit 0원")
    public void profit_other() {
        int expected = 0;

        int input = 1;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("3개는 profit  5000원")
    public void profit_3() {
        int expected = 5000;

        int input = 3;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("4개는 profit 50000원")
    public void profit_4() {
        int expected = 5000;

        int input = 3;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("5개는 profit 1500000원")
    public void profit_5() {
        int expected = 5000;

        int input = 3;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("6개는 profit 2000000000원")
    public void profit_6() {
        int expected = 5000;

        int input = 3;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }
}
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
    @DisplayName("3개는 profit  5_000원")
    public void profit_3() {
        int expected = 5_000;

        int input = 3;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("4개는 profit 50_000원")
    public void profit_4() {
        int expected = 50_000;

        int input = 4;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("5개는 profit 1_500_000원")
    public void profit_5() {
        int expected = 1_500_000;

        int input = 5;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("6개는 profit 2_000_000_000원")
    public void profit_6() {
        int expected = 2_000_000_000;

        int input = 6;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }
}
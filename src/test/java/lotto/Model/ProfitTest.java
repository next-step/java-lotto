package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {
    @Test
    @DisplayName("1,2,3,4,5등이 아닌 랭크는 profit 0원")
    public void profit_other() {
        int expected = 0;

        int input = 6;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("5등은 profit  5_000원")
    public void profit_3() {
        int expected = 5_000;

        int input = 5;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("4등은 profit 50_000원")
    public void profit_4() {
        int expected = 50_000;

        int input = 4;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("3등은 profit 1_500_000원")
    public void profit_5() {
        int expected = 1_500_000;

        int input = 3;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("2등은 profit 30_000_000원")
    public void profit_15() {
        int expected = 30_000_000;

        int input = 2;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("1등은 profit 2_000_000_000원")
    public void profit_6() {
        int expected = 2_000_000_000;

        int input = 1;
        Profit profit = new Profit(input);
        int actual = profit.value();

        assertThat(actual).isEqualTo(expected);
    }
}
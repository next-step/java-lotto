package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {

    Profit profit;

    @BeforeEach
    void setUp() {
        profit = new Profit(0);
    }

    @ParameterizedTest
    @DisplayName("수익금 계산(0 => 1, 1 => 0, 2 => 0, 3 => 5000, 4 => 50000, 5 => 1500000, 6 => 2000000000)")
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void one_time(int input, int result) {
        profit.accumulate(input);
        assertThat(profit).isEqualTo(new Profit(result));
    }

    @Test
    @DisplayName("누적 수익금 계산(3,3,4,6 => 2000060000)")
    void many_times() {
        profit.accumulate(3);
        profit.accumulate(3);
        profit.accumulate(4);
        profit.accumulate(6);
        assertThat(profit).isEqualTo(new Profit(2000060000));
    }

    @ParameterizedTest
    @DisplayName("내가 낸 금액과 수익금을 통해서 수익률 계산((14000, 5000) => 0.35, (2000, 2000000000) => 1000000, (10, 0) => 0)")
    @CsvSource(value = {"14000:5000:0.35", "2000:2000000000:1000000", "10:0:0"}, delimiter = ':')
    void calc_rate(int input1, int input2, double result) {
        Profit customProfit = new Profit(input2);
        double rate = customProfit.calcRate(input1);
        assertThat(rate).isEqualTo(result);
    }

    @Test
    void to_string() {
        profit.accumulate(3);
        assertThat(profit.toString(new Cash(2))).isEqualTo("총 수익률은 2500.00입니다.");
    }
}

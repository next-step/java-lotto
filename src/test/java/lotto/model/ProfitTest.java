package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.model.Profit.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {

    Profit profit = new Profit(10);
    List<Integer> matchingNumberCount;

    @Test
    @DisplayName("일치한 로또가격이 있으면 수익률을 계산한다. ")
    void profit() {
        matchingNumberCount = List.of(1, 1, 0, 0);
        assertThat(profit.calculate(matchingNumberCount))
                .isEqualTo((double) 55000 / (10 * LOTTO_PRICE) );
    }

    @Test
    @DisplayName("일치한 로또가격이 없으면 수익률이 0이다 ")
    void profit2() {
        matchingNumberCount = List.of(0, 0, 0, 0);
        assertThat(profit.calculate(matchingNumberCount)).isEqualTo(0);
    }
}
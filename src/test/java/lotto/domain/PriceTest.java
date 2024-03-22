package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {

    @Test
    void calculate_rate_of_return() {
        Price price = new Price(14000);
        List<Integer> eachRankCount = Arrays.asList(1, 0, 0, 0, 0, 0);
        assertThat(Math.floor(price.calculateRateOfReturn(eachRankCount) * 100) / 100.0).isEqualTo(0.35);
    }

    @Test
    void price_exception() {
        assertThatThrownBy(() -> new Price(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Rule.formatGreaterThanLottoPrice());
    }

    @Test
    void price() {
        assertThat(new Price(1000)).isEqualTo(new Price(1000));
    }

}

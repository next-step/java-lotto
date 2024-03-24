package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {

    @Test
    void calculate_rate_of_return() {
        Price price = new Price(14000);
        Map<Prize, Integer> matchCounts = Map.of(
                Prize.FIRST_PRIZE, 0,
                Prize.SECOND_PRIZE, 0,
                Prize.THIRD_PRIZE, 0,
                Prize.FOURTH_PRIZE, 0,
                Prize.FIFTH_PRIZE, 1
        );
        assertThat(Math.floor(price.calculateRateOfReturn(matchCounts) * 100) / 100.0).isEqualTo(0.35);
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

package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {

    @Test
    void 생성자_테스트() {
        Price price = new Price(10000);

        assertThat(price).isEqualTo(new Price(10000));
    }

    @Test
    void 수익률_계산() {
        Price price = new Price(1000);

        double expected = price.calculateRateOfProfit(10000);

        assertThat(expected).isEqualTo(10.0);
    }
}

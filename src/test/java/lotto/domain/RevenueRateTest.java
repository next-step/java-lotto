package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RevenueRateTest {

    @Test
    void 기본금과_결과로_수익률을_알_수_있다() {
        RevenueRate actual = new RevenueRate(5000, new BuyingAmount(14000));
        RevenueRate expected = new RevenueRate(0.35);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 이득_여부를_알_수_있다() {
        assertAll(
                () -> {
                    RevenueRate revenueRate = new RevenueRate(5000, new BuyingAmount(14000));
                    boolean actual = revenueRate.isBenefit();

                    assertThat(actual).isFalse();
                },
                () -> {
                    RevenueRate revenueRate = new RevenueRate(15000, new BuyingAmount(14000));
                    boolean actual = revenueRate.isBenefit();

                    assertThat(actual).isTrue();
                }
        );
    }

}



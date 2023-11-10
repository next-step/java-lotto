package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RevenueTest {

    @Test
    void 기본금과_결과로_수익률을_알_수_있다() {
        Revenue actual = new Revenue(5000, new BuyingAmount(14000));
        Revenue expected = new Revenue(0.35);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 이득_여부를_알_수_있다() {
        assertAll(
                () -> {
                    Revenue revenue = new Revenue(5000, new BuyingAmount(14000));
                    boolean actual = revenue.isBenefit();

                    assertThat(actual).isFalse();
                },
                () -> {
                    Revenue revenue = new Revenue(15000, new BuyingAmount(14000));
                    boolean actual = revenue.isBenefit();

                    assertThat(actual).isTrue();
                }
        );
    }

}



package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void 수익률_계산() {
        Result revenue = new Result();
        assertThat(revenue.calculate(10000, 3000)).isEqualTo(0.3);
    }

    @Test
    void 총수익() {
        Result revenue = new Result();
    }
}

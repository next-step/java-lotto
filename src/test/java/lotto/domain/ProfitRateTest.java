package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProfitRateTest {

    @Test
    void create() {
        ProfitRate actual = new ProfitRate(0.25);

        assertThat(actual).isEqualTo(new ProfitRate(0.25));
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> new ProfitRate(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}

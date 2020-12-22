package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProfitTest {

    @Test
    void valid() {
        assertThatThrownBy(() -> new Profit(Double.NaN))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Profit(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }


}

package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoYieldTest {

    @DisplayName("수익률을 계산한다")
    @Test
    void calculate() {
        assertThat(new LottoYield(14000, 5000).calculate())
                .isEqualTo(0.35);
    }
}

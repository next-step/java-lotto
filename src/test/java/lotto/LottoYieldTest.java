package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoYieldTest {

    @DisplayName("수익률을 계산한다")
    @Test
    void calculate() {
        Assertions.assertThat(new LottoYield(14000, 5000).calculate()).isEqualTo(0.35);
    }
}

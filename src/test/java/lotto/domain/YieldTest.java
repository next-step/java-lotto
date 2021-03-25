package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class YieldTest {

    @Test
    @DisplayName("수익률 구하기")
    void getYieldTest() {
        assertThat(Yield.getYield(3000, 10000L)).isEqualTo(10000L / (double) 3000);
    }
}

package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RatioTest {

    @Test
    @DisplayName("수익/손해 비율 확인")
    void ratio() {
        Ratio ratio = new Ratio();
        assertThat(ratio.lottoPer(5000, 5000)).isEqualTo(1.0);
        assertThat(ratio.lottoPer(50000, 5000)).isEqualTo(10.0);
        assertThat(ratio.lottoPer(5000, 14000)).isEqualTo(0.35);
    }

}
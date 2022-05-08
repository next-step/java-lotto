package lotto.domain;

import lotto.util.Ratio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.util.Ratio.lottoPer;
import static org.assertj.core.api.Assertions.assertThat;

class RatioTest {

    @Test
    @DisplayName("수익/손해 비율 확인")
    void ratio() {
        assertThat(lottoPer(5000, 5000)).isEqualTo(1.0);
        assertThat(lottoPer(50000, 5000)).isEqualTo(10.0);
        assertThat(lottoPer(5000, 14000)).isEqualTo(0.35);
    }

}
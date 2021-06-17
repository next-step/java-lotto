package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @DisplayName(value = "총 수익률 계산하기")
    @Test
    void calculate_earning_rate() {
        Lottos lottos = new Lottos(3);
        assertThat(lottos.calculateEarningRate(5, 2)).isEqualTo(2.5f);
    }
}

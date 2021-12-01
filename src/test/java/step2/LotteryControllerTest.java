package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.controller.LotteryController;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryControllerTest {
    @Test
    @DisplayName("수익율 계산")
    void calculateProfitRate() {
        LotteryController controller = new LotteryController();
        assertThat(controller.calculateProfitRate(14000, 5000)).isEqualTo(0.35);
    }
}

package step2.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StatisticsUtilTest {

    @ParameterizedTest
    @CsvSource({ "14000, 5000, 0.35", "15000, 50000, 3.33", "16000, 1500000, 93.75", "17000, 2000000000, 117647.05"})
    void ROI_확인_하는_테스트(int money, int rewards, BigDecimal expectedRoi) {
        BigDecimal roi = StatisticsUtil.getRoi(money, rewards);

        assertThat(roi).isEqualTo(expectedRoi);
    }
}

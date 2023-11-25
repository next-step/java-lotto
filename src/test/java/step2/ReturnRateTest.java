package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReturnRateTest {

    @Test
    void getReturnRate() {
        assertThat(ReturnRate.getReturnRate(14000,5000)).isEqualTo("0.35");
    }
}
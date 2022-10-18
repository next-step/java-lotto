package step1.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {

    @Test
    void 계산기() {
        assertThat(CalculatorService.calculate(Arrays.asList("2", "+", "3", "*", "4", "/", "2")))
                .isEqualTo(10);
    }

}
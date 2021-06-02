package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DivideUtilTest {

    @DisplayName("int형 정수 2개로 나누기 연산")
    @Test
    void divide() {
        int a = 10000;
        int b = 3000;
        double result = DivideUtil.divide(a, b);
        assertThat(result).isGreaterThanOrEqualTo(a / b);
    }

}
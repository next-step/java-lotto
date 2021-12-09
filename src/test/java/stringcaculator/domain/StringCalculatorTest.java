package stringcaculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @Test
    @DisplayName("StringCalculator의 계산이 정상적으로 이루어졌는지 확인합니다")
    void calculation() {
        assertThat(new StringCalculator(new Numbers(new String[]{"1","2","3"})).calculation())
                .isEqualTo(new Number(new StringToIntegerValue("6")));
    }
}
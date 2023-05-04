package stringCalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumbersTest {

    Numbers numbers = new Numbers();

    @Test
    @DisplayName(value = "숫자가 들어가야할 자리에 숫자가 입력되지 않았을 경우 IllegalArgumentException 발생 하는지 테스트")
    void test1() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            numbers.validNumber("*");
        });
    }
}
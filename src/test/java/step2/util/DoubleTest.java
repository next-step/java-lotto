package step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 소수점이 길면 2자리까지만 자른다.
*/
public class DoubleTest {

    @DisplayName("소수점이 길면 2자리까지만 자른다.")
    @Test
    void twoDecimalTest() {
        double num = (double) 10 / 3;
        assertThat(DoubleUtil.twoDecimal(num)).isEqualTo(3.33);
    }
}

package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DoubleParserTest {
    @DisplayName("소수점 2자리 이하 버림")
    @Test
    public void test_getTwoDecimalPoint() {
        assertThat(DoubleParser.getTwoDecimalPoint(0.354))
                .isEqualTo(0.35);
    }
}

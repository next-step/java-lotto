package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void create_instance() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("빈 문자열 또는 null을 입력하는 경우 결과값으로 0을 반환하는지 테스트")
    void input_blank_or_null() {
        int result = stringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = stringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);

        result = stringCalculator.splitAndSum("  ");
        assertThat(result).isEqualTo(0);
    }
}
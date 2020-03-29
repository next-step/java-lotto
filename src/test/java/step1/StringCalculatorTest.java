package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("빈문자열이나 null 입력시 0 반환")
    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = stringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
        result = stringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("문자하나 입력시 숫자하나 반환")
    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = stringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쉼표구분자 입력시 합 반환")
    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = stringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }
}

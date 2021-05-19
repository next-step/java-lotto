package stringCalculator.calculator;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
    StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setup() {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("기본 덧셈 계산 테스트")
    void testSum() {
        //given
        //when
        int result = stringAddCalculator.splitAndSum("1,2,3");
        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("null 또는 빈문자")
    public void testNullOrEmptyString() {
        int result = stringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나")
    public void testSumOneValue() {
        int result = stringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자")
    public void testSumComma() {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론 구분자")
    public void testSumCommaOrColon() {
        int result = stringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("custom 구분자")
    public void testSumCustom() {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("negative")
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
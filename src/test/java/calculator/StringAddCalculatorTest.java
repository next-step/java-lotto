package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 덧셈 계산기(StringAddCalculator) 테스트")
public class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        PatternReader patternReader = pattern -> Numbers.of(1, 2);
        stringAddCalculator = new StringAddCalculator(patternReader);
    }

    @DisplayName("패턴 판독기(PatternReader)로 구성된다.")
    @Test
    void create() {
        // then
        assertThat(stringAddCalculator).isNotNull();
    }

    @DisplayName("문자열을 판독하고 숫자의 합을 구할 수 있다.")
    @Test
    void sum() {
        // when
        String pattern = "";
        int sum = stringAddCalculator.sum(pattern);

        // then
        assertThat(sum).isEqualTo(3);
    }
}

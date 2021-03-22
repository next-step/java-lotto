package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void init(){
         stringAddCalculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("입력 값이 NULL이면 0을 반환하는 테스트")
    void sum_null() {
        int result = stringAddCalculator.sum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("입력값이 빈 문자면 0을 반환하는 테스트")
    void sum_빈문자() {
        int result = stringAddCalculator.sum("");
        assertThat(result).isEqualTo(0);
    }

}

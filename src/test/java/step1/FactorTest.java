package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class FactorTest {

    private Factor factor = new Factor();

    @DisplayName("사용자 정의 구분자 사용되었는지 여부 테스트")
    @Test
    void isCustomSeparatorUsedTest(){
        String numbers = "//;\n1;2;3";
        assertThat(factor.isCustomSeparatorUsed(numbers)).isTrue();
    }

    @DisplayName("사용자 정의 구분자 추출 테스트")
    @Test
    void parseCustomSeparatorTest(){
        String numbers = "//;\n1;2;3";
        String separator = factor.parseCustomSeparator(numbers);

        assertThat(separator).isEqualTo(";");
    }

    @DisplayName("사용자 정의 구분자 사용시 factor(인자) 추출 테스트")
    @Test
    void customSeparatorNumbersParsingTest(){
        String numbers = "//;\n1;2;3";
        String[] expectedFactors = {"1", "2", "3"};

        assertThat(factor.parseNumbers(numbers)).isEqualTo(expectedFactors);
    }
}

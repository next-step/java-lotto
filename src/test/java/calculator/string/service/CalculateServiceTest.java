package calculator.string.service;

import calculator.string.domain.CalculatorSign;
import calculator.string.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @DisplayName("split 기능 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 3", "1 * 3", "1 + 3 / 1"})
    public void split_테스트(String input) {
        String[] result = calculateService.split(input);
        assertThat(result).containsAnyOf("1", "+", "3", "*", "/");
    }

    @Test
    @DisplayName("빈칸이 있을 때 에러가 나는지 테스트")
    public void 빈칸일때_에러() {
        String[] testString = {"3", " "};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculateService.sectionCalculate(testString);
        });
    }

    @Test
    @DisplayName("문자열 계산기 테스트")
    public void 계산_테스트() {
        String[] testStrings = {"4", "+", "2", "*", "2", "/", "4"};
        List<Number> numbers = calculateService.sectionNumber(testStrings);
        List<CalculatorSign> calculatorSigns = calculateService.sectionCalculate(testStrings);
        int result = calculateService.iterNumbersAndCalculatorSigns(numbers, calculatorSigns);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("나눗셈의 결과가 정수가 아닐 때 테스트")
    public void 나눗셈의결과가_정수가_아닐때_테스트() {
        String[] testStrings = {"5", "/", "2"};
        List<Number> numbers = calculateService.sectionNumber(testStrings);
        List<CalculatorSign> calculatorSigns = calculateService.sectionCalculate(testStrings);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculateService.iterNumbersAndCalculatorSigns(numbers, calculatorSigns);
        });
    }
}

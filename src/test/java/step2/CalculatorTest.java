package step2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setting() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열 기준 split 테스트")
    @CsvSource(value = {"'':0", "'1,2':3", "'1,2,3':6", "'1,2:3':6", "'1:2:3':6", "'::':0"}, delimiter = ':')
    void addNumberBetweenSeparatorTest(String input, int result) {
        assertThat(calculator.addNumberBetweenSeparator(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자 기준 split 테스트")
    @CsvSource(value = {"'//;\n1;2;3':6", "'//ㅋ\n1ㅋ2ㅋ3':6", "'//ㅋ\n':0"}, delimiter = ':')
    void addNumberBetweenSeparatorTest2(String input, int result) {
        assertThat(calculator.addNumberBetweenSeparator(input)).isEqualTo(result);
    }

}

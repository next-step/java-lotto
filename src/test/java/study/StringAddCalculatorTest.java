package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @DisplayName("입력받은 문자열 null or empty 검증")
    @ParameterizedTest
    @NullAndEmptySource
    public void validateInput(String input) {
        boolean result = stringAddCalculator.validateInput(input);
        assertThat(result).isFalse();
    }

    @DisplayName("input 문자열 쉼표와 콜론 구분하여 문자열 반환 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "1:2,3"})
    public void splitInput(String input) {
        String[] result = stringAddCalculator.splitInput(input);
        assertThat(result).containsExactly("1","2","3");
    }

    @DisplayName("배열의 sum 반환 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6", "2:2:4=8", "1:2,3,10=16", "10:24,1,1:1=37", "224,111=335"}, delimiter = '=')
    public void sumNumbers(String input, int expected) {
        Numbers numbers = new Numbers(stringAddCalculator.splitInput(input));
        int result = stringAddCalculator.sumNumbers(numbers.getNumbers());
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("input 문자열 숫자 하나 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "7:7", "3:3", "4:4"}, delimiter = ':')
    public void splitAndSum_숫자하나(String input, int expected) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("splitAndSum 함수 쉼표구분자 결과 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "2,2,4:8", "1,2,3,10:16", "10,24:34", "224,111:335"}, delimiter = ':')
    public void splitAndSum_쉼표구분자(String input, int expected) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("splitAndSum 함수 쉼표 또는 콜론 구분자 결과 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6", "2:2:4=8", "1:2,3,10=16", "10:24,1,1:1=37", "224,111=335"}, delimiter = '=')
    public void splitAndSum_쉼표_또는_콜론_구분자(String input, int expected) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("input 문자열 custom 구분자로 구분하여 문자열 반환 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//-\n1-2-3", "//@\n1@2@3", "// \n1 2 3"})
    public void splitAndSum_custom_split(String input) {
        String[] result = stringAddCalculator.splitInput(input);
        assertThat(result).containsExactly("1","2","3");
    }

    @DisplayName("splitAndSum 함수 custom 구분자 sum 결과 확인")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//-\n1-2-3", "// \n1 2 3", "//@\n1@2@3"})
    public void splitAndSum_custom_구분자_더하기(String input) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(6);
    }
}

package study.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import study.calculator.SentenceCalculator;

public class TestOperationCalculator {


    @ParameterizedTest(name = "SentenceCalculator 객체 - 빈값 문자열 생성자 테스트")
    @NullAndEmptySource
    public void test_calculator_constructor_null(String sentence) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new SentenceCalculator(sentence))
            .withMessageMatching("유효하지 않은 연산입니다");
    }


    @ParameterizedTest(name = "SentenceCalculator 객체 - 공백(구분자) 없는 문자열 파싱 테스트")
    @CsvSource({"5+5+5"})
    public void test_calculator_without_separation(String sentence) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new SentenceCalculator(sentence))
            .withMessageMatching("연산은 반드시 빈 공백 문자열을 포함해야 합니다");
    }


    @ParameterizedTest(name = "SentenceCalculator 객체 - 불완전한 문자열 파싱 테스트")
    @CsvSource({"5 + "})
    public void test_calculator_calculate_not_complete(String sentence) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new SentenceCalculator(sentence))
            .withMessageMatching("완전하지 않은 연산입니다");
    }



    @ParameterizedTest(name = "SentenceCalculator 객체 - 사칙연산이 아닌경우 테스트")
    @CsvSource({"5 # 5 + 5", "2 + 3 @ 4 / 2"})
    public void test_calculate_not_operation(String sentence) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new SentenceCalculator(sentence).doCalculate())
            .withMessageMatching("유효하지 않은 연산입니다");
    }


    @ParameterizedTest(name = "SentenceCalculator 객체 - 사칙연산이 아닌경우 테스트")
    @CsvSource({"+ + 5 + 5", "2 + - - 4 / 2"})
    public void test_calculate_not_number(String sentence) {
        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> new SentenceCalculator(sentence).doCalculate());
    }


    @ParameterizedTest(name = "SentenceCalculator 객체 - 문자열 연산 테스트")
    @CsvSource({"5 + 5 + 5, 15", "2 + 3 * 4 / 2, 10"})
    public void test_calculate_success(String sentence, int result) {
        assertThat(new SentenceCalculator(sentence).doCalculate())
            .isEqualTo(result);
    }

}

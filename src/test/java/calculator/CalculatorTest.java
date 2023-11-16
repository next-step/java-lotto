package calculator;

import calculator.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.domain.Calculator.calculate;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 기능")
    void 덧셈_기능() {
        assertThat(calculate("1 + 2")).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 기능")
    void 뺄셈_기능() {
        assertThat(calculate("10 - 3")).isEqualTo(7);
    }

    @Test
    @DisplayName("곱셈 기능")
    void 곱셈_기능() {
        assertThat(calculate("3 * 4")).isEqualTo(12);
    }

    @Test
    @DisplayName("나눗셈 기능")
    void 나눗셈_기능() {
        assertThat(calculate("10 / 5")).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈의 결과가 정수가 아닌 경우 IllegalArgumentException이 발생한다.")
    void 정수가_아닌_나눈셈_결괏값일_경우_에러를_발생한다() {
        assertThatThrownBy(() -> calculate("1 + 2 * 3 / 2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("빈 공백 문자일 경우 IllegalArgumentException 발생한다.")
    void 빈_공백_문자열을_입력하면_IllegalArgumentException_발생한다(String value) {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.checkNullOrEmpty(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("null일 경우 IllegalArgumentException 발생한다.")
    @NullAndEmptySource
    void Null_을_입력할_경우_IllegalArgumentException_발생한다(String value) {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.checkNullOrEmpty(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산이 아닌 경우 IllegalArgumentException이 발생한다.")
    void 사칙_연산이_아닌_경우_IllegalArgumentException_발생한다() {
        assertThatThrownBy(() -> calculate("1 % 2 # 4 / 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산을 포함한 계산 기능")
    void 사칙_연산을_포함한_계산_기능() {
        int result = calculate("1 + 2 * 4 / 3");
        assertThat(result).isEqualTo(4);
    }
}

package stringformula;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringformula.exception.InvalidNumberValueException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    @DisplayName("plus 메소드는 두 Number 객체의 더하기 연산을 수행한 결과를 Number 객체로 반환한다")
    void 테스트_plus_더하기_연산_결과_반환() {
        assertThat(new Number(1).plus(new Number(2))).isEqualTo(new Number(3));
    }

    @Test
    @DisplayName("valueOf 메소드는 문자열 값을 통해 Number 객체를 생성")
    void 테스트_valueOf_문자열_객체_생성() {
        assertThat(Number.valueOf("1")).isEqualTo(new Number(1));
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("valueOf 메소드는 null이나 빈 값 문자열이 들어오면 0을 반환")
    void 테스트_valueOf_문자열_null_빈문자열_처리(String value) {
        assertThat(Number.valueOf(value)).isEqualTo(new Number(0));
    }

    @Test
    @DisplayName("valueOf 메소드는 음수의 문자열 값이 들어오면 예외 발생")
    void 테스트_valueOf_음수_문자열_예외_발생() {
        assertThrows(InvalidNumberValueException.class, () -> Number.valueOf("-1"));
    }

    @Test
    @DisplayName("valueOf 메소드는 숫자가 아닌 문자열 값이 들어오면 예외 발생")
    void 테스트_valueOf_숫자가_아닌_문자열_예외_발생() {
        assertThrows(NumberFormatException.class, () -> Number.valueOf("A"));
    }

}
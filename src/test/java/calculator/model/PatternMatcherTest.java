package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PatternMatcherTest {

    @Test
    @DisplayName("연산자 이외에 문자가 있어서는 안된다")
    void 연산자_validate() {
        assertThat(PatternMatcher.validate("+-*/")).isTrue();
        assertThat(PatternMatcher.validate("@!%^&()")).isFalse();
    }

    @Test
    @DisplayName("숫자 이외에 문자가 있어서는 안된다")
    void 숫자_validate() {
        assertThat(PatternMatcher.validate("0123456789+-*/")).isTrue();
        assertThat(PatternMatcher.validate("abcdefg")).isFalse();
    }

    @Test
    @DisplayName("공백 문자가 포함되어있으면 안된다")
    void 공백_validate() {
        assertThat(PatternMatcher.validate(" ")).isFalse();
    }

}
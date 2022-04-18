package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("문자열 분리")
class StringSeparatorTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> StringSeparator.from("1 2"));
    }

    @ParameterizedTest
    @DisplayName("문자열은 필수")
    @NullAndEmptySource
    void instance_nullOrEmptyArguments_thrownIllegalArgumentException(String string) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringSeparator.from(string));
    }

    @Test
    @DisplayName("기본 구분자로 문자 나누기")
    void strings() {
        assertThat(StringSeparator.from("1").strings()).containsExactly("1");
        assertThat(StringSeparator.from("1 2").strings()).containsExactly("1", "2");
        assertThat(StringSeparator.from("a b c").strings()).containsExactly("a", "b", "c");
    }
}

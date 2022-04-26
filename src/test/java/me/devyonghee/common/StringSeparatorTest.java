package me.devyonghee.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("문자열 분리")
class StringSeparatorTest {

    @Test
    @DisplayName("구분할 문자열로 문자열 분리 정상 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> StringSeparator.from("1 2"));
    }

    @Test
    @DisplayName("구분자가 없으면 기본 구분자로 생성")
    void instance_nullDelimiter() {
        assertThatNoException().isThrownBy(() -> StringSeparator.of("1 2", null));
    }

    @Test
    @DisplayName("문자와 커스텀 구분자로 문자열 분리 정상 생성")
    void instance_delimiter() {
        assertThatNoException().isThrownBy(() -> StringSeparator.of("1", ","));
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

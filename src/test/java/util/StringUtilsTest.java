package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 유틸리티 테스트")
public class StringUtilsTest {

    @DisplayName("문자열이 null 이거나 빈 값일 경우 true 를 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void isEmpty(String inputString) {
        assertThat(StringUtils.isEmpty(inputString)).isTrue();
    }

    @DisplayName("문자열이 자연수 일 경우 true 그렇지 않으면 false 를 리턴한다.")
    @MethodSource
    @ParameterizedTest
    void isNaturalNumber(String inputString, boolean expectedValue) {
        assertThat(StringUtils.isNaturalNumber(inputString)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> isNaturalNumber() {
        return Stream.of(
                Arguments.of("0", true),
                Arguments.of("5", true),
                Arguments.of("10", true),
                Arguments.of("-1", false),
                Arguments.of("", false),
                Arguments.of(null, false)
        );
    }
}

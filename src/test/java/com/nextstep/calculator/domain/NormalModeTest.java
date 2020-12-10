package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NormalModeTest {
    @DisplayName("기본 구분자로 구분된 문자열을 계산용 도메인으로 변환할 수 있다.")
    @ParameterizedTest
    @MethodSource("toNumbersTestResource")
    void toNumbersTest(String value, Numbers expected) {
        Mode mode = new NormalMode(value);

        assertThat(mode.parseToNumbers()).isEqualTo(expected);
    }
    public static Stream<Arguments> toNumbersTestResource() {
        return Stream.of(
                Arguments.of(
                        "1:2:3:4:5,6",
                        new Numbers(Arrays.asList(Number.of("1"), Number.of("2"), Number.of("3"),
                                        Number.of("4"), Number.of("5"), Number.of("6")))
                ),
                Arguments.of(
                        "1:2:3:4",
                        new Numbers(Arrays.asList(Number.of("1"), Number.of("2"), Number.of("3"), Number.of("4")))
                ),
                Arguments.of(
                        "1",
                        new Numbers(Collections.singletonList(Number.of("1")))
                )
        );
    }

    @DisplayName("잘못된 입력값으로 구분 시도 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1.2.3.4.5", "1-2-3-4-5", "1,2:3.4"})
    void toNumbersFailTest(String invalidValue) {
        Mode mode = new NormalMode(invalidValue);

        assertThatThrownBy(mode::parseToNumbers).isInstanceOf(InvalidNumberException.class);
    }

    @DisplayName("구분자로 사용될 문자열을 받을 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1:2:3:4:5,6", "1:2:3:4", "1"})
    void extractSeparatorTest(String value) {
        Mode mode = new NormalMode(value);
        String expected = "[:,]";

        assertThat(mode.extractSeparator()).isEqualTo(expected);
    }

    @DisplayName("나눠야 할 문자열을 받을 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1:2:3:4:5,6", "1:2:3:4", "1"})
    void extractSeparateTargetTest(String value) {
        Mode mode = new NormalMode(value);

        assertThat(mode.extractSeparateTarget()).isEqualTo(value);
    }
}

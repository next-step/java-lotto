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

package com.nextstep.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ModeSelectorTest {
    @DisplayName("커스텀 모드 여부를 알 수 있다.")
    @ParameterizedTest
    @MethodSource("isCustomTestResource")
    void isCustomTest(String value, boolean expected) {
        ModeSelector modeSelector = new ModeSelector(value);

        assertThat(modeSelector.isCustom()).isEqualTo(expected);
    }
    public static Stream<Arguments> isCustomTestResource() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", true),
                Arguments.of("/\n1;2;3", false),
                Arguments.of("1;2;3", false)
        );
    }

    @DisplayName("상황에 따라 맞는 셀렉터를 반환한다.")
    @Test
    void selectTest() {
        String value = "//;\n1;2;3";

        ModeSelector modeSelector = new ModeSelector(value);

        assertThat(modeSelector.select()).isEqualTo(new CustomMode("1;2;3", ";"));
    }
}

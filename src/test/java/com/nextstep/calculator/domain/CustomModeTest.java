package com.nextstep.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CustomModeTest {
    private static final String SAMPLE_SEPARATOR = "-";

    @DisplayName("커스텀 구분자로 사용할 문자를 인자로 전달해서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        assertThat(new CustomMode(SAMPLE_SEPARATOR)).isNotNull();
    }

    @DisplayName("커스텀 구분자로 구분된 Numbers로 변환할 수 있다.")
    @Test
    void parseToNumbersTest() {
        String value = "1-2-3-4-5-6";
        Numbers expected = new Numbers(
                Arrays.asList(Number.of("1"), Number.of("2"), Number.of("3"),
                        Number.of("4"), Number.of("5"), Number.of("6"))
        );

        CustomMode customMode = new CustomMode(SAMPLE_SEPARATOR);

        assertThat(customMode.parseToNumbers(value)).isEqualTo(expected);
    }
}

package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomModeTest {
    private static final String SAMPLE_SEPARATOR = "-";

    @DisplayName("커스텀 구분자로 사용할 문자열과 나눌 문자열을 인자로 전달해서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        String value = "1-23-4";

        assertThat(new CustomMode(value, SAMPLE_SEPARATOR)).isNotNull();
    }

    @DisplayName("커스텀 구분자로 구분된 Numbers로 변환할 수 있다.")
    @Test
    void parseToNumbersTest() {
        String value = "1-2-3-4-5-6";
        Numbers expected = new Numbers(
                Arrays.asList(Number.of("1"), Number.of("2"), Number.of("3"),
                        Number.of("4"), Number.of("5"), Number.of("6"))
        );

        CustomMode customMode = new CustomMode(value, SAMPLE_SEPARATOR);

        assertThat(customMode.parseToNumbers()).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자 외 구분자로 구분된 문자열 파싱 시도 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1-5,2"})
    void parseToNumbersFailTest(String invalidValue) {
        CustomMode customMode = new CustomMode(invalidValue, SAMPLE_SEPARATOR);

        assertThatThrownBy(customMode::parseToNumbers)
                .isInstanceOf(InvalidNumberException.class);
    }
}

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

    @DisplayName("구분자로 사용될 문자열을 추출할 수 있다.")
    @Test
    void extractSeparatorTest() {
        String value = "1-23-4";

        CustomMode customMode = new CustomMode(value, SAMPLE_SEPARATOR);
        assertThat(customMode.extractSeparator()).isEqualTo(SAMPLE_SEPARATOR);
    }

    @DisplayName("나눠야 할 문자열을 추출할 수 있다.")
    @Test
    void extractSeparateTargetTest() {
        String value = "1-23-4";

        CustomMode customMode = new CustomMode(value, SAMPLE_SEPARATOR);
        assertThat(customMode.extractSeparateTarget()).isEqualTo(value);
    }
}

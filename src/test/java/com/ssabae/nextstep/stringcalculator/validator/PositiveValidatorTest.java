package com.ssabae.nextstep.stringcalculator.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-15
 */
@DisplayName("계산기 숫자 Validation Test Class")
class PositiveValidatorTest {

    private final PositiveValidator validator = new PositiveValidator();

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("Validator 양수 Test - Success")
    @ValueSource(ints = {0, 1, 10})
    void shouldBeTruePositiveValidatorTest(int value) {
        boolean validate = validator.validate(value);
        assertThat(validate).isTrue();
    }

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("Validator 음수 Test - Exception")
    @ValueSource(ints = {-1, -10})
    void shouldBeFalsePositiveValidatorTest(int value) {
        assertThatThrownBy(() -> validator.validate(value))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 허용되지 않습니다.");
    }

}

package stringcaculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("유효한 Input 객체가 반환되는지 확인합니다")
    void validValid(String value) {
        assertThat(new Input(value).validValue().equals(new Input("0"))).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3","1:2:3","1,2:3"})
    @DisplayName("정상적으로 splitedInput가 실행되는지 확인합니다")
    void splitedInput(String value) {
        String[] result = {"1", "2", "3"};
        assertThat(new Input(value).splitedInput(DELEMETER_REGEX.GENERAL)).isEqualTo(result);
    }

}
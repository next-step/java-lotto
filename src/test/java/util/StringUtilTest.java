package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.util.StringUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @DisplayName("null, 공백 문자열일 경우 true를 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void isBlankReturnTrue(String input) {
        assertThat(StringUtil.isBlank(input)).isTrue();
    }

    @DisplayName("null, 공백 문자가 아닐 경우 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1+2"})
    void isBlankReturnFalse(String input) {
        assertThat(StringUtil.isBlank(input)).isFalse();
    }

//    @DisplayName("사용자의 입력을 공백으로 나눌 수 있다.")
//    @ParameterizedTest
//    @ValueSource(strings = {"1 + 2", "3 * 4 "})
//    void splitWithSpace(String input) {
//
//        List<String> result = StringUtil.splitBySpace(input);
//
//        assertThat(result).hasSize(3)
//                .element(1)
//                .isIn(List.of("+", "*", "-", "%"));
//    }
}
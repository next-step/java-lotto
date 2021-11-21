package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValueTest {
    @Test
    @DisplayName("InputValue 생성자 테스트")
    public void create() {
        assertThat(new InputValue("1")).isEqualTo(new InputValue("1"));
    }

    @ParameterizedTest
    @DisplayName("입력값은 null 또는 빈문자일 수 없다.")
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String inputStringValue) {
        assertThat(new InputValue(inputStringValue).isNullOrBlank()).isTrue();
    }

    @Test
    @DisplayName("숫자가 하나로 되어있는지 테스트")
    public void isOneOnlyNumber() {
        assertThat(new InputValue("1").isOneLengthOnlyNumber()).isTrue();
        assertThat(new InputValue("12").isOneLengthOnlyNumber()).isFalse();
    }

    @Test
    @DisplayName("컴마(,)로 입력값을 분리한다.")
    public void getSeparatedValuesByComma() {
        assertThat(new InputValue("1,2").getSeparatedValuesByComma()).contains(1, 2);
    }

    @Test
    @DisplayName("두개 이상의 숫자로만 되어있는지 테스트")
    public void isMoreThanTwoNumber() {
        assertThat(new InputValue("1,2,3,3").isMoreThanTwoNumber()).isFalse();
        assertThat(new InputValue("12").isMoreThanTwoNumber()).isTrue();
    }

    @Test
    @DisplayName("컴마(,) 또는 콜론(:) 구분자인지 테스트")
    public void isCommaOrColonSeparator() {
        assertThat(new InputValue("1,2:3").isCommaOrColonSeparator()).isTrue();
    }

    @Test
    @DisplayName("컴마(,) 또는 콜론(:)로 입력값을 분리한다.")
    public void getSeparatedValuesByCommaOrColon() {
        assertThat(new InputValue("1,2:3").getSeparatedValuesByCommaOrColon()).contains(1, 2, 3);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자인지 테스트")
    public void isCustomSeparator() {
        assertThat(new InputValue("//;\n1;2;3").isCustomSeparator()).isTrue();
    }

    @Test
    @DisplayName("“//”와 “\\n”로 입력값을 분리한다.")
    public void getSeparatedValuesByCustom() {
        assertThat(new InputValue("//;\n1;2;3").getSeparatedValuesByCustom()).contains(1, 2, 3);
    }
}

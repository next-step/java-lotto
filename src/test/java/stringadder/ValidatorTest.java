package stringadder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    private static final String[] EMPTY_ARRAY = {};

    @DisplayName("입력값이 null 값 경우 빈 배열 반환한다.")
    @Test
    void validateWithNull() {
        Validator validator = new Validator(null);

        assertThat(validator.validate()).isEqualTo(EMPTY_ARRAY);
    }
    @DisplayName("입력값이 빈 문자열일 경우 빈 배열 반환한다.")
    @Test
    void validateWithEmptyString() {
        Validator validator = new Validator("");

        assertThat(validator.validate()).isEqualTo(EMPTY_ARRAY);
    }

    @DisplayName("구분자가 없을 경우에도 구분을 잘하는지")
    @Test
    void validateWithComma() {
        Validator validator = new Validator("1");

        assertThat(validator.validate()).isEqualTo(new String[]{"1"});
    }

    @DisplayName(",(콤마) 구분자를 사용하여 숫자를 구분할 수 있다.")
    @Test
    void validateWithoutDelimiter() {
        Validator validator = new Validator("1,2");

        assertThat(validator.validate()).isEqualTo(new String[]{"1","2"});
    }

    @DisplayName(":(콜론) 구분자를 사용하여 숫자를 구분할 수 있다.")
    @Test
    void validateWithColon() {
        Validator validator = new Validator("1:2");

        assertThat(validator.validate()).isEqualTo(new String[]{"1","2"});
    }

    @DisplayName("사용자가 원하는 커스텀 구분자를 사용할 수 있다.")
    @Test
    void MultipleNumberWithCustomDelimeter() {
        Validator validator = new Validator("//;\n1;2");

        assertThat(validator.validate()).isEqualTo(new String[]{"1","2"});
    }
}
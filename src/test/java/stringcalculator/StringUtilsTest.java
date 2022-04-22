package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import stringcalculator.domain.StringUtils;
import stringcalculator.exception.BlankInputException;
import stringcalculator.exception.InvalidNumberException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilsTest {

    @Test
    @DisplayName("공백 기준으로 문자 리스트 반환")
    void returnStringArraySplitWithSpace() {
        String[] input = StringUtils.getStringArray("a b c");
        assertThat(input).hasSize(3).containsExactly("a", "b", "c");
    }

    @Test
    @DisplayName("해당 인덱스의 String 을 int 로 변환")
    void parseIntByIndex() {
        String[] input = {"1", "2", "3"};
        int a = StringUtils.toInt(input, 0);
        int b = StringUtils.toInt(input, 1);
        int c = StringUtils.toInt(input, 2);

        assertThat(a).isEqualTo(1);
        assertThat(b).isEqualTo(2);
        assertThat(c).isEqualTo(3);
    }

    @Test
    @DisplayName("int 변환 실패시 InvalidNumberException 예외 발생")
    void throwInvalidNumberExceptionWhenFailParsing() {
        assertThatThrownBy(() -> StringUtils.toInt(new String[]{"a"}, 0))
                .isInstanceOf(InvalidNumberException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("input이 null 혹은 empty 이면 BlankInputException 예외 발생")
    void throwBlankInputException(String input) {
        assertThatThrownBy(() -> StringUtils.getStringArray(input))
                .isInstanceOf(BlankInputException.class);
    }
}
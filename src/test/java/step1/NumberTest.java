package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,3"})
    @DisplayName("숫자 파싱 테스트")
    void parserIntTest(String str, int num) {
        Number number = new Number(str);
        assertThat(number.parserInt(str)).isEqualTo(num);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("문자가 공백으로 들어오면 0을 반환한다")
    void blankTest(String str) {
        assertThat(new Number(str).parserInt(str)).isEqualTo(0);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null 들어오면 0을 반환한다")
    void nullTest(String str) {
        assertThat(new Number(str).parserInt(str)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "!", "("})
    @DisplayName("숫자이외의 문자를 입력하면 오류 발생")
    void convertStringToNumber(String str) {
        assertThatThrownBy(() -> new Number(str))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자이외의 문자는 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    @DisplayName("음수를 입력하면 오류발생")
    void validationCheck(String negativeNumber) {
        assertThatThrownBy(() -> new Number(negativeNumber))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 입력할 수 없습니다.");
    }
}

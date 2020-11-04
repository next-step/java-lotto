package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void init() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)")
    void nullAndEmptyTest(String input) {
        assertThat(stringCalculator.sum(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)")
    void unitNumberTest() {
        assertThat(stringCalculator.sum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)")
    void sumByCommaTest() {
        assertAll(
                () -> assertThat(stringCalculator.sum("1,2")).isEqualTo(3),
                () -> assertThat(stringCalculator.sum("10,20")).isEqualTo(30)
        );
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)")
    void sumByCommaAndColonTest() {
        assertAll(
                () -> assertThat(stringCalculator.sum("1,2:3")).isEqualTo(6),
                () -> assertThat(stringCalculator.sum("10,20:30")).isEqualTo(60)
        );
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\\n1;2;3” => 6)")
    void customDelimiterTest() {
        assertAll(
                () -> assertThat(stringCalculator.sum("//;\\n1;2;3")).isEqualTo(6),
                () -> assertThat(stringCalculator.sum("//;\\n1,2;3")).isEqualTo(6),
                () -> assertThat(stringCalculator.sum("//;\\n1,2:3;4")).isEqualTo(10)
        );
    }
}

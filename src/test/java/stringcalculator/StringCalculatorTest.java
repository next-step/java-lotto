package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(String test) {
        assertThat(stringCalculator.calculator(test)).isZero();
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void oneNumber(final String text) {
        assertThat(stringCalculator.calculator(text)).isSameAs(Integer.parseInt(text));
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void twoNumbers(final String text) {
        assertThat(stringCalculator.calculator(text)).isSameAs(3);
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    void colons(final String text) {
        assertThat(stringCalculator.calculator(text)).isSameAs(6);
    }


    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    void customDelimiter(final String text) {
        assertThat(stringCalculator.calculator(text)).isSameAs(6);
    }


    @DisplayName(value = "커스텀 구분자와 기존 , or : 를 같이 사용하면 , : 는 무시한다. ex) //;\n1,2:3;4 = 123+4 =127 ")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1,2:3;4"})
    void DelimiterAndCoustomDelimiter(final String text) {
        assertThat(stringCalculator.calculator(text)).isSameAs(127);
    }

    @DisplayName("구분자로 나눠주는 테스트")
    @Test
    void split() {

        assertAll("calculator",
                () -> assertEquals(stringCalculator.getDelimiter("1,2:3:4"), Arrays.asList(1, 2, 3, 4)),
                () -> assertEquals(stringCalculator.getDelimiter("//;\n1;2;3"), Arrays.asList(1, 2, 3)),
                () -> assertEquals(stringCalculator.getDelimiter("//;\n1,2:3;4"), Arrays.asList(123, 4))
        );
    }

    @DisplayName(value = "더하기 테스트")
    @Test
    void sum() {
        List<Integer> strcharList = Arrays.asList(123, 4);
        assertThat(stringCalculator.sum(strcharList)).isEqualTo(127);
    }


    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    void negative() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> stringCalculator.minusThrowException("-1"));
    }
}

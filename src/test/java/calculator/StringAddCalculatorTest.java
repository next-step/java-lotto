package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

class StringAddCalculatorTest {


    @ParameterizedTest(name = "[{index}] {0}의 결과는 0 이다.")
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void splitAndSum_nullOrEmpty(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @RepeatedTest(10)
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void splitAndSum_singleNumber(RepetitionInfo repetitionInfo) {
        int number = repetitionInfo.getCurrentRepetition();
        int result = StringAddCalculator.splitAndSum(String.valueOf(number));
        assertThat(number).isEqualTo(result);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.)")
    void splitAndSum_comman_delimit() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 두개를 콜론(:) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void splitAndSum_colon_delimit() {
        int result = StringAddCalculator.splitAndSum("1:2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    void splitAndSum_commandAndcolon_delimit() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    void splitAndSum_custom_delimit() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
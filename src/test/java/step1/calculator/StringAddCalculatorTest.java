package step1.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.number.PositiveNumber;
import step1.number.PositiveNumbers;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @DisplayName("splitAndSum에 null 또는 빈 문자열을 넣었을 때 반환되는 값에 대한 테스트")
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("splitAndSum에 유효한 숫자값 하나를 넣었을 때의 반환값 검증 테스트")
    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("splitAndSum에 유효한 숫자와 쉼표 입력시 반환되는 값 검증 테스트")
    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("splitAndSum에 유효한 숫자와 쉼표 또는 콜론 입력시 반환되는 값 검증 테스트")
    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("splitAndSum에 유효한 숫자와 커스텀 구분자 입력시 반환되는 값 검증 테스트")
    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("splitAndSum에 음수 입력시 예외처리 발생 여부 테스트")
    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() ->
                StringAddCalculator.splitAndSum("-1,2,3")
        ).isInstanceOf(RuntimeException.class); // 요구사항에 RuntimeException 으로 검증하는 것이 있어서 이렇게 테스트했습니다.
    }

    @DisplayName("splitAndSum에 유효한 경계값 입력시 덧셈기능이 동작하는지 여부 테스트")
    @Test
    void 검증_경계값() {
        // given
        List<PositiveNumber> inputData = Arrays.asList(PositiveNumber.valueOf(0), PositiveNumber.valueOf(127));

        // when
        PositiveNumbers positiveNumbers = new PositiveNumbers(inputData);
        int actual = positiveNumbers.sum();

        // then
        assertThat(actual).isEqualTo(127);
    }

}
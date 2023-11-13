import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("입력 문자열의 숫자와 사칙 연산자를 빈 공백 문자로 구분한다.")
    void 문자열_공백으로_구분(){
        String inputString = "2 + 3 * 4 / 2";
        List<Integer> numberList = SplitString.splitNumber(inputString);
        List<String> operatorList = SplitString.splitOperator(inputString);

        assertThat(numberList).contains(2,3,4,2);
        assertThat(operatorList).containsExactly("+","*","/");
    }

    @Test
    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 예외를 반환한다.")
    void 입력값_예외처리(){
        String inputNull = null;
        String inputBlank = " ";

        assertThatThrownBy( () -> {
            assertThat(SplitString.splitNumber(inputNull));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy( () -> {
            assertThat(SplitString.splitNumber(inputBlank));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

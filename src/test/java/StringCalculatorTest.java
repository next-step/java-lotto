import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}

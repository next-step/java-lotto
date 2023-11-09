import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @DisplayName("사용자가 입력한 문자열에 따라 사칙연산을 수행할 수 있는 계산기를 구현")
    @Test
    void 사용자입력문자_사칙연산() {
        Calculator calculator = new Calculator(Integer.parseInt("1"));
        calculator.plus(Integer.parseInt("2"));
        assertThat(calculator.getResult()).isEqualTo(3);
        calculator.minus(Integer.parseInt("1"));
        assertThat(calculator.getResult()).isEqualTo(2);
        calculator.multiply(Integer.parseInt("4"));
        assertThat(calculator.getResult()).isEqualTo(8);
        calculator.divide(Integer.parseInt("4"));
        assertThat(calculator.getResult()).isEqualTo(2);
        calculator.clear();
        assertThat(calculator.getResult()).isEqualTo(0);
    }

    @DisplayName("입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정")
    @Test
    void 사용자입력문자열_연산() {
        String data = "1 + 2 - 1 * 3 / 3";
        String[] dataArr = data.split(" ");
        Calculator calculator = new Calculator(Integer.parseInt(dataArr[0]));
        for (int i=1; i<dataArr.length; i+=2) {
            if (dataArr[i].equals("+")) {
                calculator.plus(Integer.parseInt(dataArr[i+1]));
            } else if (dataArr[i].equals("-")) {
                calculator.minus(Integer.parseInt(dataArr[i+1]));
            } else if (dataArr[i].equals("*")) {
                calculator.multiply(Integer.parseInt(dataArr[i+1]));
            } else {
                calculator.divide(Integer.parseInt(dataArr[i+1]));
            }
        }
        assertThat(calculator.getResult()).isEqualTo(2);
    }
}

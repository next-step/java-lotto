package lotto.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열 계산기 객체 생성")
    void createStringCalculator() {
        String input = "3,4:5";
        StringCalculator calculator = new StringCalculator(input);
        assertThat(calculator).isEqualTo(new StringCalculator(input));
    }

    @Test
    @DisplayName("구분자(,:)를 기준으로 분리")
    void splitDelimiter() {
        String input = "3,4,5";
        StringCalculator calculator = new StringCalculator(input);
        String[] array =  calculator.splitDelimiter();
        assertThat(array).containsExactly("3", "4", "5");
    }

    @Test
    @DisplayName("분리된 숫자 합")
    void add() {
        String input = "3,4,5";
        StringCalculator calculator = new StringCalculator(input);
        String[] array =  calculator.splitDelimiter();
        int result = calculator.add(array);
        assertThat(result).isEqualTo(12);
    }

}

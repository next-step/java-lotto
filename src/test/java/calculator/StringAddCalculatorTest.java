package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("Numbers를 add하는 요청을 받으면 Integer 리턴함")
    @Test
    public void getSum() {
        String userInput = "1:2:3:4:5:6:7:8:9:10";
        Numbers numbers = new Numbers(StringParser.parseString(userInput));
        Integer calculationResult = StringAddCalculator.getNumbersSum(numbers);

        assertThat(calculationResult).isEqualTo(55);
    }
}

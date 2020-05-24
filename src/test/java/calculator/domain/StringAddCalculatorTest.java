package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

    @DisplayName("UserInput이 null or empty일 때 결과값이 0이 리턴됨")
    @ParameterizedTest
    @NullAndEmptySource
    public void getZeroWhenNullOrEmpty(String userInput) {
        Numbers numbers = new Numbers(StringParser.parseString(userInput));
        Integer calculationResult = StringAddCalculator.getNumbersSum(numbers);

        assertThat(calculationResult).isEqualTo(0);
    }
}

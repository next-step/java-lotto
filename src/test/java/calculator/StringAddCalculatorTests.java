package calculator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTests {
    StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setup(){
        stringAddCalculator = new StringAddCalculator();
    }

    @DisplayName("null 이나 빈 문자열 시 0 반환 테스트")
    @ParameterizedTest
    @EmptySource
    void blankOrNullTest(String input){
        int result = stringAddCalculator.calculate(input);

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나 만 넣었을 때 넣은 숫자 반환하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void inputOneNumberTest(String input){
        int result = stringAddCalculator.calculate(input);

        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("숫자 사이에 , 넣었을 때 두 숫자의 합을 반환하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2 : 3", "2,3: 5", "3,4 : 7"} , delimiter = ':')
    void commaAddTest(String input, String expected){;
        int result = stringAddCalculator.calculate(input);

        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("숫자가 여러개의 , 를 포함 할 때 합을 반환하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3 : 6", "2,3,5,7,9: 26", "3,8,10,13,100 : 134"} , delimiter = ':')
    void commaAddMultiNumberTest(String input, String expected){
        int result = stringAddCalculator.calculate(input);

        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("숫자가 여러개의 , 나 : 를 포함 할 때 합을 반환하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3 = 6", "2,3:5:7,9 = 26", "3:8,10,13:100 = 134"} , delimiter = '=')
    void commaAddMultiNumberWithCommaColonTest(String input, String expected){
        int result = stringAddCalculator.calculate(input);

        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("숫자가 custom 구분자를 포함 할 때 합을 반환하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3 = 6", "//&\\n2&4&6&8&10 = 30", "//#\\n3#8#10#13#100 = 134"} , delimiter = '=')
    void customAddTest(String input, String expected){
        int result = stringAddCalculator.calculate(input);

        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("음수 전달 시 RuntimeException 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"//;\\n-1;2;3", "1,-2:3", "1,2,-3"})
    void negativeExceptionTest(String input){
        System.out.println(input);

        assertThatThrownBy(() -> stringAddCalculator.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }

}

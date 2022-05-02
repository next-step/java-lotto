package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OperatorTest {
    Plus plus = new Plus();
    Minus minus = new Minus();
    Multiply multiply = new Multiply();
    Division division = new Division();

    @ParameterizedTest
    @CsvSource(value = {"1:1:2", "4:5:9", "3:4:7"}, delimiter = ':')
    void 덧셈_테스트(String a, String b, String result) {
        assertThat(plus.execute(new NumberElement(a), new NumberElement(b)))
                .isEqualTo(new NumberElement(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:0", "4:5:-1", "9:3:6"}, delimiter = ':')
    void 뺄셈_테스트(String a, String b, String result) {
        assertThat(minus.execute(new NumberElement(a), new NumberElement(b)))
                .isEqualTo(new NumberElement(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "4:5:20", "3:4:12"}, delimiter = ':')
    void 곱셈_테스트(String a, String b, String result) {
        assertThat(multiply.execute(new NumberElement(a), new NumberElement(b)))
                .isEqualTo(new NumberElement(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "8:2:4", "6:3:2"}, delimiter = ':')
    void 나눗셈_테스트(String a, String b, String result) {
        assertThat(division.execute(new NumberElement(a), new NumberElement(b)))
                .isEqualTo(new NumberElement(result));
    }
}

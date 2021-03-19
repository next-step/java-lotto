package step1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringSumTest {

    private StringSum stringSum;

    @BeforeEach
    void setUp() {
        this.stringSum = new StringSum("[,:]");
    }

    @DisplayName("쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하면 쉼표로 구분한 각 숫자의 합을 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3|6", "1,2|3", "1|1"}, delimiter = '|')
    void sum(String input, int sum) {
        Result result = stringSum.sum(input);
        assertEquals(new Result(sum), result);
    }

    @DisplayName("입력이 빈 문자열이면 0을 반환")
    @Test
    void empty() {
        String input = "";
        Result result = stringSum.sum(input);
        assertEquals(new Result(0), result);
    }

    @DisplayName("입력이 null이면 0을 반환")
    @Test
    void inputNull() {
        String input = null;
        Result result = stringSum.sum(input);
        assertEquals(new Result(0), result);
    }

    @DisplayName("커스텀 구분자")
    @Test
    void customDelimiter() {
        String input = "//;\n1;2;3";
        Result result = stringSum.sum(input);
        assertEquals(new Result(6), result);
    }
}

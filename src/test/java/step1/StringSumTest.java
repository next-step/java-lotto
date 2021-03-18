package step1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringSumTest {

    @Test
    @DisplayName("쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하면 쉼표로 구분한 각 숫자의 합을 반환")
    void empty() {
        String input = "1,2:3";
        StringSum stringSum = new StringSum();
        Result result = stringSum.sum(input);
        assertEquals(new Result(6), result);
    }
}

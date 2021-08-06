package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("숫자 컬렉션 테스트")
public class NumbersTest {

    @DisplayName("숫자의 합을 구하는 기능이 정상 동작해야 한다.")
    @Test
    public void sumTest() {
        // given
        Numbers numbers = Numbers.of(new String[]{"1", "2", "3"});

        // when, then
        assertEquals(numbers.sum(), 6);
    }
}

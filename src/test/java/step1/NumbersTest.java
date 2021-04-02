package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @ParameterizedTest(name = "구분자 기준으로 문자열 추출하는 테스트")
    @ValueSource(strings = {"1,3,5", "1:3:5", "//;\n1;3;5", "//&\n1&3&5"})
    void splitString(String given) {
        List<String> expected = Arrays.asList("1","3","5");

        Numbers numbers = new Numbers(given);
        List<String> actual = numbers.splitString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("배열을 정수형 리스트로 변환하는지 테스트")
    void listConvertedFromArray(){
        // given
        String given = "1,3,5";
        List<Integer> expected = Arrays.asList(1, 3, 5);

        // when
        Numbers  numbers = new Numbers(given);
        List<Integer> actual = numbers.getNumbers();

        // then
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "음수또는 숫자 타입 검증하는 테스트")
    @ValueSource(strings = {"1,3,h", "-1,3,5","1,-3,5","1,3,-5"})
    void hasNegativeNumber(String given) {

        assertThrows(RuntimeException.class, () -> {
            Numbers numbers = new Numbers(given);
            numbers.listConvertedFromArray();
        });

    }
}

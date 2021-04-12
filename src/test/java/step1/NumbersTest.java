package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumbersTest {

    @ParameterizedTest(name = "음수나 숫자가 아닐경우 RuntimeException 발생")
    @ValueSource(strings = {"-1","1,-1", "-1,2","-2,3"})
    void throwsExceptionWhenNotNumberOrNegativeNumber(String given) {
        System.out.println(given.length());
        assertThrows(RuntimeException.class, () -> {
            new Numbers(given, new StringSplitter());
        });
    }

    @ParameterizedTest(name = "number getter 테스트")
    @ValueSource(strings = {"1,3,5", "1:3:5", "//;\n1;3;5"})
    void getNumbers(String given){
        // when
        Numbers numbers = new Numbers(given, new StringSplitter());
        List<Integer> actual = numbers.getNumbers();

        // then
        assertThat(actual).containsExactly(1,3,5);
    }
}

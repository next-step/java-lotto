package calc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputCheckerTest {

    @Test
    void 빈문자열_null_입력시_0을_반환테스트() {
        assertThat(new InputChecker(null).getNumbers()).isEqualTo(Arrays.asList(0));
        assertThat(new InputChecker("").getNumbers()).isEqualTo(Arrays.asList(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    void 숫자_하나를_문자열로_입력하면_해당_숫자를_반환테스트(String input) {
        assertThat(new InputChecker(input).getNumbers())
            .isEqualTo(Arrays.asList(Integer.parseInt(input)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "3,4", "1,3", "100,10"})
    void 숫자_두개를_컴마_구분자로_입력하면_두_숫자의_리스트를_반환테스트(String input) {
        List<Integer> numbers = new InputChecker(input).getNumbers();
        String[] inputNumbers = input.split(",");
        assertThat(numbers.size()).isEqualTo(2);
        assertThat(numbers).contains(Integer.parseInt(inputNumbers[0]));
        assertThat(numbers).contains(Integer.parseInt(inputNumbers[1]));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:2", "3:4", "1:3", "100:10"})
    void 숫자_두개를_콜론_구분자로_입력하면_두_숫자의_리스트를_반환테스트(String input) {
        List<Integer> numbers = new InputChecker(input).getNumbers();
        String[] inputNumbers = input.split(":");
        assertThat(numbers.size()).isEqualTo(2);
        assertThat(numbers).contains(Integer.parseInt(inputNumbers[0]));
        assertThat(numbers).contains(Integer.parseInt(inputNumbers[1]));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:2", "3,4", "1:3", "100,10"})
    void 숫자_두개를_컴마콜론_구분자로_입력하면_두_숫자의_리스트를_반환테스트(String input) {
        List<Integer> numbers = new InputChecker(input).getNumbers();
        String[] inputNumbers = input.split(":|,");
        assertThat(numbers.size()).isEqualTo(2);
        assertThat(numbers).contains(Integer.parseInt(inputNumbers[0]));
        assertThat(numbers).contains(Integer.parseInt(inputNumbers[1]));
    }

    @Test
    void 커스텀_구분자를_입력하면_두_숫자의_리스트를_반환테스트() {
        List<Integer> numbers = new InputChecker("//;\n1;2;3").getNumbers();
        String[] inputNumbers = "1;2;3".split(";");
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).contains(Integer.parseInt(inputNumbers[0]));
        assertThat(numbers).contains(Integer.parseInt(inputNumbers[1]));
        assertThat(numbers).contains(Integer.parseInt(inputNumbers[2]));
    }
}

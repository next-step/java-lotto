package calc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputCheckerTest {

    @Test
    void 빈문자열_null_입력시_0을_반환테스트() {
        assertThat(new InputChecker(null).getNumbers()).isEqualTo(new Numbers(Arrays.asList(0)));
        assertThat(new InputChecker("").getNumbers()).isEqualTo(new Numbers(Arrays.asList(0)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    void 숫자_하나를_문자열로_입력하면_해당_숫자를_반환테스트(String input) {
        Numbers inputNumbers = new InputChecker(input).getNumbers();
        assertThat(inputNumbers)
            .isEqualTo(new Numbers(Arrays.asList(Integer.parseInt(input))));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "3,4", "1,3", "100,10"})
    void 숫자_두개를_컴마_구분자로_입력하면_두_숫자의_리스트를_반환테스트(String input) {
        String[] inputNumbers = input.split(",");
        assertThat(new InputChecker(input).getNumbers()).isEqualTo(new Numbers(inputNumbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:2", "3:4", "1:3", "100:10"})
    void 숫자_두개를_콜론_구분자로_입력하면_두_숫자의_리스트를_반환테스트(String input) {
        String[] inputNumbers = input.split(":");
        assertThat(new InputChecker(input).getNumbers()).isEqualTo(new Numbers(inputNumbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:2", "3,4", "1:3", "100,10"})
    void 숫자_두개를_컴마콜론_구분자로_입력하면_두_숫자의_리스트를_반환테스트(String input) {
        String[] inputNumbers = input.split(":|,");
        assertThat(new InputChecker(input).getNumbers()).isEqualTo(new Numbers(inputNumbers));
    }

    @Test
    void 커스텀_구분자를_입력하면_두_숫자의_리스트를_반환테스트() {
        String[] inputNumbers = "1;2;3".split(";");
        assertThat(new InputChecker("//;\n1;2;3").getNumbers()).isEqualTo(new Numbers(inputNumbers));
    }

    @Test
    void 음수를_입력하면_런타임_예외_발생테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new InputChecker("-1,2,3").getNumbers();
        });
    }
}

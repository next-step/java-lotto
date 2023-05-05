package domain.formula;

import static domain.formula.Numbers.NUMBER_FORMAT_EXCEPTION;
import static domain.formula.Numbers.getNumbersByFormula;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    @DisplayName("숫자가 아닌 값을 숫자 위치에 입력했을 경우 오류가 발생한다.")
    void parseIntErrorTest() {
        List<String> formula = List.of(new String[]{"+", "4", "-"});
        assertThatThrownBy(() -> getNumbersByFormula(formula))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_FORMAT_EXCEPTION);
    }


    @Test
    @DisplayName("정확한 값이 입력되면 Numbers 객체가 생성된다.")
    void makeNumbers() {
        List<String> formula = List.of(new String[]{"1", "+", "2", "+", "3"});
        Numbers numbersByFormula = getNumbersByFormula(formula);

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        Numbers numbers = new Numbers(integerList);

        assertThat(numbersByFormula).isEqualTo(numbers);
    }
}

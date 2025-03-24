package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class FormulaTest {

    @Test
    @DisplayName(value = "공식을 배열로 변환")
    void 공식_배열_변환(){

        Formula formula = new Formula("2 * 3");

        assertThat(formula.getCalculateTarget()).containsExactly("+", "2", "*", "3");
    }
}

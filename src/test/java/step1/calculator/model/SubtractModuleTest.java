package step1.calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SubtractModuleTest {

    @Test
    @DisplayName("Subtract(-) 테스트")
    void givenTwoIntegers_whenSubtract_thenReturnDifference() {
        // given
        int a = 3;
        int b = 2;
        SubtractModule subtractModule = new SubtractModule();

        // when
        int result = subtractModule.calculate(a, b);

        // then
        assertThat(result).isEqualTo(1);
    }

}

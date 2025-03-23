package step1.calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DivideModuleTest {

    @Test
    @DisplayName("Divide(/) 테스트")
    void givenTwoIntegers_whenDivide_thenReturnQuotient() {
        // given
        int a = 6;
        int b = 3;
        DivideModule divideModule = new DivideModule();

        // when
        int result = divideModule.calculate(a, b);

        // then
        assertThat(result).isEqualTo(2);
    }

}

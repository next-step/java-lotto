package step1.calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MultiplyModuleTest {

    @Test
    @DisplayName("Multiply(*) 테스트")
    void givenTwoIntegers_whenMultiply_thenReturnProduct() {
        // given
        int a = 2;
        int b = 3;
        MultiplyModule multiplyModule = new MultiplyModule();

        // when
        int result = multiplyModule.calculate(a, b);

        // then
        assertThat(result).isEqualTo(6);
    }

}

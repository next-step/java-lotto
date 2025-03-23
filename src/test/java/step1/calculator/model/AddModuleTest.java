package step1.calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddModuleTest {

    @Test
    @DisplayName("Add(+) 테스트")
    void givenTwoIntegers_whenAdd_thenReturnSum() {
        // given
        int a = 1;
        int b = 2;
        AddModule addModule = new AddModule();

        // when
        int result = addModule.calculate(a, b);

        // then
        assertThat(result).isEqualTo(3);
    }

}

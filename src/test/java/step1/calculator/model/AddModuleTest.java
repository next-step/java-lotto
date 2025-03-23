package step1.calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddModuleTest {

    @Test
    @DisplayName("Add(+) 테스트")
    void given_two_integers_when_add_then_return_sum() {
        // given
        int a = 1;
        int b = 2;
        AddModule addModule = new AddModule();

        // when
        int result = addModule.calculate(a, b);

        // then
        assert result == 3;
    }

}

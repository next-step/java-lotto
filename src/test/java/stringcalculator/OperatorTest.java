package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"#", "^", "&"})
    void 사칙연산_기호가_아닌_경우(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Operator(input);
        });
    }
}
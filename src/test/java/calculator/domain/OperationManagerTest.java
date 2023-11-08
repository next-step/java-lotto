package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperationManagerTest {

    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 2, 10", "3 / 1 + 5, 8"})
    void 주어진_값을_가지고_연산하면_결과가_나온다(String input, int expected) {
        int actual = OperationManager.operate(input);

        assertThat(actual).isEqualTo(expected);
    }

}
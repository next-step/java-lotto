package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.domains.CalculateOperator;
import step1.exceptions.EmptyStringException;

public class CalculateOperatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void Given_Null_Or_Empty_When_Create_Then_Fail(String input) {
        assertThatThrownBy(() -> new CalculateOperator(input))
                .isInstanceOf(EmptyStringException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 : 2",
            "1 | 2",
            "1 ? 1",
            "1 + 2 * 3 | 4"
    })
    void Given_Not_Operator_When_Create_Then_Fail(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new CalculateOperator(input)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 + 2",
            "1 - 2",
            "1 * 2",
            "2 / 2",
            "1 + 2 * 3 / 4 - 5"
    })
    void Given_Valid_String_When_Create_Then_Success(String input) {
        assertThatNoException().isThrownBy(
                () -> new CalculateOperator(input)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "1 + 1, 2",
            "1 / 1, 1",
            "2 + 3 * 4 / 2, 10"
    })
    void Given_String_When_Calculate_Then_Success(String input, int expected) {
        CalculateOperator operator = new CalculateOperator(input);

        assertThat(operator.calculate()).isEqualTo(expected);
    }
}

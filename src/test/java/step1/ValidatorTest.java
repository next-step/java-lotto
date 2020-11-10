package step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    @Test
    void checkCustomDelimiter() {
        Assertions.assertAll(
                () -> {
                    assertThat(
                            Validator.checkCustomDelimiter("1,2,3")
                    ).isEqualTo(false);
                },
                () -> {
                    assertThat(
                            Validator.checkCustomDelimiter("//;\n1;2;3")
                    ).isEqualTo(true);
                }
        );
    }

    @ParameterizedTest
    @CsvSource(value={"1$true", "1,2$false"}, delimiter = '$')
    void checkSingle(String input, boolean expected) {
        assertThat(
                Validator.checkSingle(input)
        ).isEqualTo(expected);
    }

    @Test
    void checkZero() {
        Assertions.assertAll(
                () -> {
                    assertThat(Validator.checkZero(""))
                            .isEqualTo(true);
                },
                () -> {
                    assertThat(Validator.checkZero(null))
                            .isEqualTo(true);
                },
                () -> {
                    assertThat(Validator.checkZero("1"))
                            .isEqualTo(false);
                }
        );
    }
}

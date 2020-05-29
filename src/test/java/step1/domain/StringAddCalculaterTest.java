package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringAddCalculaterTest {

    // init with 0
    @DisplayName("init Class")
    @ParameterizedTest
    @ValueSource(strings = {"", "0"})
    public void testClassInitialize(String numbers) {
        StringAddCalculater stringAddCalculater = new StringAddCalculater();
        assertThat(stringAddCalculater.splitAndSum(numbers)).isEqualTo(0);
    }

    @DisplayName("null check")
    @ParameterizedTest()
    @NullAndEmptySource
    public void testClassWithNull(String numbers) {

        StringAddCalculater stringAddCalculater = new StringAddCalculater();
        assertThat(stringAddCalculater.splitAndSum(numbers)).isEqualTo(0);
    }

    @DisplayName("Negetive number")
    @ParameterizedTest
    @ValueSource(strings = {"-1,3:4", "1,-300:100"})
    public void testClassOnError(String numbers) {

        StringAddCalculater stringAddCalculater = new StringAddCalculater();

        Throwable throwable = assertThrows(RuntimeException.class, () -> {
            stringAddCalculater.splitAndSum(numbers);
        });
        assertEquals("Found a negative number(s)", throwable.getMessage());

    }

    @DisplayName("Not numbers")
    @ParameterizedTest
    @ValueSource(strings = {"A,3:4", "1,Z:100"})
    public void testClassOnRuntimeError(String numbers) {

        StringAddCalculater stringAddCalculater = new StringAddCalculater();

        Throwable throwable = assertThrows(RuntimeException.class, () -> {
            stringAddCalculater.splitAndSum(numbers);
        });
        assertEquals("Found a Not a number(s)", throwable.getMessage());
    }


    @DisplayName("cumtom delimiter")
    @ParameterizedTest
    @ValueSource(strings = {"//!\n3,3:4!58"})
    public void testClassOnCustomDelimiter(String numbers) {
        StringAddCalculater stringAddCalculater = new StringAddCalculater();
        assertThat(stringAddCalculater.splitAndSum(numbers)).isEqualTo(68);

    }


}

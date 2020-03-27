package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CustomNumbersTest {

    @Test
    void create() {
        CustomNumber first = CustomNumber.of(0);
        CustomNumber second = CustomNumber.of(3);
        CustomNumbers customNumbers = new CustomNumbers(Arrays.asList(first, second));

        assertThat(customNumbers.getCustomNumbers()).containsExactly(first, second);
    }

    @Test
    void create_inputString() {
        String[] input = {"1", "5", "8"};
        CustomNumbers customNumbers = new CustomNumbers(input);

        assertThat(customNumbers.getCustomNumbers()).containsExactly(CustomNumber.of(1)
                , CustomNumber.of(5)
                , CustomNumber.of(8));
    }

    @Test
    void create_inputStringInvalid_throwRuntimeException() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            String[] input = {"1", "5", "ff"};
            new CustomNumbers(input);
        });
    }

    @Test
    void sum() {
        CustomNumber first = CustomNumber.of(0);
        CustomNumber second = CustomNumber.of(3);
        CustomNumber third = CustomNumber.of(9);
        CustomNumbers customNumbers = new CustomNumbers(Arrays.asList(first, second, third));

        int result = customNumbers.sum();

        assertThat(result).isEqualTo(12);
    }
}

package stringcalculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void 숫자_이외의_값_음수를_전달하면_에러_반환() {
        List<String> numbers = Arrays.asList("1", "2", "-11as", "a");
        final Number number = new Number(numbers);
        assertThatThrownBy(number::checkIfPositiveNumber)
            .isInstanceOf(RuntimeException.class);
    }
}




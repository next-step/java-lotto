package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void assertToIntArray() {
        List<Object> result = new ArrayList<>();
        result.add(1);
        result.add("+");
        result.add(1);

        assertThat(Calculator.toIntArray("1 + 1")).isEqualTo(result);
    }
}
package calculation;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberTest {
    Numbers numbers;

    @BeforeEach
    public void setup() {
        List<Number> number = Arrays.asList(
                new Number(1),
                new Number(2)
        );

        numbers = new Numbers(number);
    }

    @Test
    @DisplayName("합계 계산")
    public void calculateSum() {
        assertThat(numbers.sum()).isEqualTo(3);
    }

}

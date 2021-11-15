package calculation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberTest {
    Numbers numbers;

    @BeforeEach
    public void setup() {
        List<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(2);

        numbers = new Numbers(number);
    }

    @Test
    @DisplayName("합계 계산")
    public void calculateSum(){
        assertThat(numbers.sum()).isEqualTo(3);
    }

}

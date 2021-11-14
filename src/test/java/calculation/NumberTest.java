package calculation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberTest {
    int[] numbers;

    @BeforeEach
    public void setup() {
        numbers = new int[]{1, 2};
    }

    @Test
    @DisplayName("객체 생성시 만들어지는 상태값을 확인한다.")
    public void createNumber(){
        Number number = new Number(numbers);
        assertThat(number.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("덧셈 된 값을 확인한다.")
    public void calculatePlus(){
        Number number = new Number(numbers);
        number.plus(numbers[1]);
        assertThat(number.getNumber()).isEqualTo(3);
    }

}

package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionTest {

    @DisplayName("덧셈 테스트")
    @Test
    public void add() {
        //given
        int firstNumber = 1;
        int secondNumber = 2;
        //when
        int result = Addition.calculate(firstNumber, secondNumber);
        //then
        assertThat(result).isEqualTo(3);
    }
}

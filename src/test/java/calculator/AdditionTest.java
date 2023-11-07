package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionTest {

    private Addition addition;

    @BeforeEach
    public void setUp() {
        addition = new Addition();
    }

    @DisplayName("덧셈 테스트")
    @Test
    public void add() {
        //given
        int firstNumber = 1;
        int secondNumber = 2;
        //when
        int result = addition.calculate(firstNumber, secondNumber);
        //then
        assertThat(result).isEqualTo(3);
    }
}

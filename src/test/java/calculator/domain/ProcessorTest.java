package calculator.domain;

import calculator.io.ConsoleInputHandler;
import calculator.io.InputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class ProcessorTest {


    @DisplayName("복잡한 수식을 처리할 수 있다.")
    @Test
    void processArithmeticExpressionTest() {
        // given
        String simulatedUserInput = "2 + 3 * 4 / 2";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(inputStream);

        InputHandler inputHandler = new ConsoleInputHandler();
        String[] expression = inputHandler.getArithmeticExpressionFromUser();

        // when
        int result = ArithmeticProcessor.processExpression(expression);

        // then
        assertThat(result).isEqualTo(10);

        System.setIn(System.in); // 복원
    }
}

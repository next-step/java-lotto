package step2.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.Calculator;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    @DisplayName("구매 금액 입력받기")
    void calculatorTest1() {

        int inputCost = InputView.inputCost();

        assertThat(inputCost).isEqualTo(3000);
    }
}

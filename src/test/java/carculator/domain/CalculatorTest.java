package carculator.domain;

import carculator.domain.token.ExpressionParser;
import carculator.view.fake.FakeInputView;
import carculator.view.output.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static carculator.view.InputViewTest.INPUT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("계산기는 계산을 할 수 있다.")
    public void calculatorTest() {
        FakeInputView fakeInputView = new FakeInputView(INPUT);
        Calculator calculator = new Calculator(fakeInputView, new OutputView());

        Integer result = calculator.calculate(ExpressionParser.parseTokens(fakeInputView.read()));
        assertThat(result).isEqualTo(10);
    }
}

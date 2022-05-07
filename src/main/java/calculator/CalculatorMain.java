package calculator;

import calculator.domain.CalculateInput;
import calculator.view.CalculateInputView;
import calculator.view.CalculateResultView;

public class CalculatorMain {
    public static void main(String[] args) {
        String inputs = CalculateInputView.scan("계산할 값을 입력해주세요.");

        CalculateInput calculateInput = new CalculateInput(inputs);
        int result = calculateInput.splitAndCalculate();

        CalculateResultView.renderResult(result);
    }
}

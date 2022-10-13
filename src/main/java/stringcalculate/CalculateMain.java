package stringcalculate;

import stringcalculate.view.InputView;

public class CalculateMain {
    public static void main(String[] args) {
        InputValue inputValue = InputView.askInput();
        StringCalculator stringCalculator = new StringCalculator(inputValue);
        System.out.println(stringCalculator.calculate());
    }
}

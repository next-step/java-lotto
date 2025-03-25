package calculator;

import calculator.ui.InputView;

public class Main {

    public static void main(String[] args) {
        String input = InputView.get();
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate(input);

        System.out.println("결과는 " + result + " 입니다.");
    }
}

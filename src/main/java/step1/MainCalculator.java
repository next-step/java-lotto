package step1;

import step1.view.InputView;

public class MainCalculator {

    public static void main(String[] args) {
        String ex = InputView.inputString("계산식을 입력해주세요.");
        Formula formula = new Formula(ex);

        StringCalculator sc = new StringCalculator();

        System.out.println(sc.calculate(formula));
    }
}

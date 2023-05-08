package lotto.step1;

import lotto.step1.domain.Calculator;
import lotto.step1.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Calculator calculator = inputView.inputData();
        System.out.println("연산 결과: "+calculator.getResult());
    }
}

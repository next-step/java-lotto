package calculate;

import calculate.domain.Executor;
import calculate.view.InputView;

public class Main {
    public static void main(String[] args) {
        int result = new Executor(InputView.initCalculate()).calculate();
        System.out.println("결과값은 = " + result + "입니다.");
    }
}

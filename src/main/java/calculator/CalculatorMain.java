package calculator;

import calculator.domain.Processor;
import calculator.view.InputView;

public class CalculatorMain {

    // e.g. "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
    public static void main(String[] args) {
        String calLine = InputView.getCalLine();
        System.out.println(new Processor().calculate(calLine));
    }

}

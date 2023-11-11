package step1;

import step1.domain.StringCalculator;
import step1.domain.operator.*;
import step1.domain.operator.impl.Add;
import step1.domain.operator.impl.Divide;
import step1.domain.operator.impl.Multiply;
import step1.domain.operator.impl.Subtract;
import step1.view.InputView;
import step1.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Application {


    public static void main(String[] args) {
        List<Operator> operatorList = Arrays.asList(new Add(), new Subtract(), new Multiply(), new Divide());
        String input = InputView.input();
        OutputView.printResult(new StringCalculator(operatorList).calculate(input));
    }
}

package calculator;

import calculator.domain.Calculator;
import calculator.domain.NumberGroup;
import calculator.domain.OperatorGroup;
import calculator.domain.InputConverter;
import calculator.view.InputView;

import java.util.List;

public class CalculatorApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String formula = inputView.askFormula();

        InputConverter inputConverter = new InputConverter();
        List<String> formulaList = inputConverter.formulaToStrList(formula);

        NumberGroup numberGroup = new NumberGroup(formulaList);
        OperatorGroup operatorGroup = new OperatorGroup(formulaList);

        Calculator calculator = new Calculator();

        Double result = calculator.calculateFormula(numberGroup.numberList(), operatorGroup.operatorQueue());

        System.out.println(result);
    }
}

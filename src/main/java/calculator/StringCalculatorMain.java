package calculator;

import calculator.domain.OperandGroup;
import calculator.domain.OperandGroupOffset;
import calculator.domain.OperatorGroup;
import calculator.domain.OperatorGroupOffset;
import calculator.domain.extractor.OperandExtractor;
import calculator.domain.extractor.OperatorExtractor;
import calculator.service.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class StringCalculatorMain {

    public static void main(String[] args) {
        List<String> inputList = InputView.requestExpression();

        StringCalculator stringCalculator = new StringCalculator(getOperatorGroup(inputList), getOperandGroup(inputList));
        int result = stringCalculator.calculate();

        OutputView.printResult(result);
    }

    public static OperatorGroup getOperatorGroup(List<String> inputList) {
        return OperatorGroup.of(
                OperatorGroupOffset.initialize()
                , new OperatorExtractor()
                , inputList
        );
    }

    public static OperandGroup getOperandGroup(List<String> inputList) {
        return OperandGroup.of(
                OperandGroupOffset.initialize()
                , new OperandExtractor()
                , inputList
        );
    }
}

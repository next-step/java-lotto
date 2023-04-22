import domain.OperandGroup;
import domain.OperandGroupOffset;
import domain.OperatorGroup;
import domain.OperatorGroupOffset;
import domain.extractor.OperandExtractor;
import domain.extractor.OperatorExtractor;
import service.StringCalculator;
import view.InputView;
import view.OutputView;

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

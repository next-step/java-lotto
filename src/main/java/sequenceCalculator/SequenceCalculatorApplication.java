package sequenceCalculator;

import static sequenceCalculator.view.InputView.*;
import static sequenceCalculator.view.ResultView.*;

public class SequenceCalculatorApplication {

    private final static SequenceCalculator calculator = new SequenceCalculator();

    public static void main(String[] args) {
        String sequence = inputSequence();
        printResult(calculator.calculate(sequence));
    }
}

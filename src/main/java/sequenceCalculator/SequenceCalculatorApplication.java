package sequenceCalculator;

import static view.InputView.*;
import static view.ResultView.*;

public class SequenceCalculatorApplication {

    private final static SequenceCalculator calculator = new SequenceCalculator();

    public static void main(String[] args) {
        String sequence = inputSequence();
        printResult(calculator.calculate(sequence));
    }
}

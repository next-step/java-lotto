package step1_caculator.domain;

import step1_caculator.view.OutputView;

import java.util.List;

import static step1_caculator.view.InputView.scanInputs;

public class Calculator {

    public void run() {
        List<String> inputs = scanInputs();
        CalculationExecutor calculationExecutor = new CalculationExecutor();
        SequenceProcessor sequenceProcessor = new SequenceProcessor(calculationExecutor);
        OutputView.printOutput(sequenceProcessor.process(inputs));
    }
}

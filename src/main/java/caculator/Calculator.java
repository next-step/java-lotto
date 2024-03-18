package caculator;

import java.util.List;

public class Calculator {
    private Number initNumber;
    private final List<OperationPair> operationPairs;

    public Calculator(String inputText) {
        OperationWrapper operationWrapper = new OperationWrapper(TextParser.textToStringList(inputText));
        this.initNumber = operationWrapper.getInitNumber();
        this.operationPairs = operationWrapper.getOperationPairs();
    }

    public Number run() {
        for (OperationPair operationPair : operationPairs) {
            OperatorType operatorType = operationPair.getOperatorType();
            initNumber = operatorType.apply(initNumber, operationPair.getNumber());
        }
        return initNumber;
    }
}

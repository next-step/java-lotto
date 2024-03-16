package caculator;

import caculator.type.OperatorType;

import java.util.List;

public class Calculator {
    private final Number initNumber;
    private final List<OperationPair> operationPairs;


    public Calculator(OperationWrapper operationWrapper) {
        this.initNumber = operationWrapper.getInitNumber();
        this.operationPairs = operationWrapper.getOperationPairs();
    }

    public Number run() {
        for (OperationPair operationPair : operationPairs) {

            Number other = operationPair.getNumber();
            switch (operationPair.getOperatorType()) {
                case PLUS:
                    initNumber.plus(other);
                    break;
                case MINUS:
                    initNumber.minus(other);
                    break;
                case DIVIDE:
                    initNumber.divide(other);
                    break;
                case MULTIPLE:
                    initNumber.multiple(other);
                    break;
            }
        }

        return initNumber;
    }
}

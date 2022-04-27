package step1;

import java.util.List;

public class StringCalculator {


    private static final OperationMapper OPERATION_MAPPER = new OperationMapper();
    private static final OperationStrategy INITIALIZE_STRATEGY = Operator.ADD.getOperationStrategy();

    private final List<String> splits;
    private OperationStrategy operationStrategy;
    private Number result;

    public StringCalculator(String text) {
        this.splits = initSplits(text);
        this.result = new Number(0);
        this.operationStrategy = INITIALIZE_STRATEGY;
    }

    private List<String> initSplits(String text) {
        return List.of(new Input(text).split());
    }

    public Number calculate() {
        splits.forEach(this::calculateEach);
        return result;
    }

    private void calculateEach(String each) {
        if (OPERATION_MAPPER.isOperator(each)) {
            changeOperation(each);
            return;
        }
        updateResult(operationStrategy, each);
    }

    private void changeOperation(String each) {
        this.operationStrategy = OPERATION_MAPPER.getOperationStrategy(each);
    }

    private void updateResult(OperationStrategy operationStrategy, String each) {
        this.result = this.result.operate(operationStrategy, new Number(each));
    }
}

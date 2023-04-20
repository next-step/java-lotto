package calculator.domain;

public final class Calculator {

    private Calculator() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static int calculate(CalculatorItems items) {
        int cumulativeResult = items.nextAsInt();
        while (items.hasNext()) {
            Operation operation = getOperation(items.nextAsString());
            cumulativeResult = operation.calculate(cumulativeResult, items.nextAsInt());
        }
        return cumulativeResult;
    }

    private static Operation getOperation(String operator) {
        Operator foundOperator = Operator.findOperator(operator);
        return foundOperator.toOperation();
    }

}
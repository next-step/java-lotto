package calculator;

public final class Calculator {

    private static final String DELIMITER = " ";

    private Calculator() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static int calculate(String input) {
        String[] items = input.split(DELIMITER);
        return calculateItems(items);
    }

    private static int calculateItems(String[] items) {
        int startNumber = Integer.parseInt(items[0]);
        return calculateRepeat(items, startNumber);
    }

    private static int calculateRepeat(String[] items, int startNumber) {
        int cumulativeResult = startNumber;
        for (int i = 1; i < items.length; i += 2) {
            Operation operation = getOperation(items[i]);
            cumulativeResult = operation.calculate(cumulativeResult, Integer.parseInt(items[i + 1]));
        }
        return cumulativeResult;
    }

    private static Operation getOperation(String operatorAsString) {
        Operator operator = Operator.findOperator(operatorAsString);
        return operator.toOperation();
    }
    
}
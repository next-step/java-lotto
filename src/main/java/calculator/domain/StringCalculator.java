package calculator.domain;

public class StringCalculator {

    private static final int START_NUM_INDEX = 0;

    private final String[] stringList;

    public StringCalculator(final String[] stringList) {
        this.stringList = stringList;
    }

    public int calculate() {
        NumberValue result = new NumberValue(stringList[START_NUM_INDEX]);
        for (int i = START_NUM_INDEX + 1; i < stringList.length; i += 2) {
            Operation op = Operation.findBySymbol(stringList[i]);
            NumberValue numberValue = new NumberValue(stringList[i + 1]);
            result = op.apply(result, numberValue);
        }
        return result.getValue();
    }
}

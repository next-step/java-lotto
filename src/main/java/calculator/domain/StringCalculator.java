package calculator.domain;

public class StringCalculator {

    private static final int START_NUM_INDEX = 0;

    private final String[] stringList;

    public StringCalculator(final String[] stringList) {
        this.stringList = stringList;
    }

    public int calculate() {
        int result = Integer.parseInt(stringList[START_NUM_INDEX]);
        for (int i = START_NUM_INDEX + 1; i < stringList.length; i += 2) {
            Operation op = Operation.findBySymbol(stringList[i]);
            result = op.apply(result, Integer.parseInt(stringList[i + 1]));
        }
        return result;
    }
}

package calculator.domain;

import calculator.utils.StringUtils;

import java.util.List;

public class StringCalculator {

    private static final int START_NUM_INDEX = 0;

    private final List<String> stringList;

    public StringCalculator(final List<String> stringList) {
        this.stringList = reformatList(stringList);
    }

    private static List<String> reformatList(final List<String> stringList) {
        int lastIndex = stringList.size() - 1;
        if (!StringUtils.isNumeric(stringList.get(lastIndex))) {
            return stringList.subList(START_NUM_INDEX, lastIndex);
        }
        if (!StringUtils.isNumeric(stringList.get(lastIndex - 1)) && StringUtils.isEmpty(stringList.get(lastIndex))) {
            return stringList.subList(START_NUM_INDEX, lastIndex - 1);
        }
        return stringList;
    }

    public int calculate() {
        NumberValue result = new NumberValue(stringList.get(START_NUM_INDEX));
        for (int i = START_NUM_INDEX + 1; i < stringList.size(); i += 2) {
            Operation op = Operation.findBySymbol(stringList.get(i));
            NumberValue numberValue = new NumberValue(stringList.get(i + 1));
            result = op.apply(result, numberValue);
        }
        return result.getValue();
    }
}

package stringcalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExtractFormula {
    public static final String DELIMITER = " ";
    public static final int INPUT_LENGTH_LOWER_BOUND = 3;
    public static final int TWO = 2;
    public static final int IS_DIVIDED = 0;

    private ExtractFormula() {
        throw new AssertionError();
    }

    public static List<String> splitText(String input) {
        List<String> result = Arrays.asList(input.split(DELIMITER));
        validate(result);
        return Collections.unmodifiableList(result);
    }

    private static void validate(List<String> inputs) {
        if (inputs.size() < INPUT_LENGTH_LOWER_BOUND) {
            throw new IllegalArgumentException("입력값은 공백으로 구분하여 3개 이상이어야 합니다. inputs : " + inputs);
        }
        if (isEven(inputs)) {
            throw new IllegalArgumentException("입력값은 계산가능한 홀수 개수 형태로 주어져야 합니다. inputs : " + inputs);
        }
    }

    private static boolean isEven(List<String> inputs) {
        return inputs.size() % TWO == IS_DIVIDED;
    }
}

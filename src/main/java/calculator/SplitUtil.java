package calculator;

import java.util.ArrayList;
import java.util.List;

public class SplitUtil {
    private static final String DEFAULT_DELIMITER = "[,:]";

    public static Operands splitByDelimiter(String input) {
        List<Operand> operands = new ArrayList<>();
        String[] splitString = input.split(DEFAULT_DELIMITER);
        for (String operand : splitString) {
            operands.add(new Operand(operand));
        }
        return new Operands(operands);
    }
}

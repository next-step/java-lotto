package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumExpression {
    private static final String CAPTURED_DELIMETER_NAME = "delimter";
    private static final String EMPTY = "";
    private static final Pattern DELIMETER_PATTERN = Pattern.compile(String.format("//(?<%s>.)\n", CAPTURED_DELIMETER_NAME));
    private static final String DEFAULT_DELIMETER = ",|:";

    private final Operands operands;

    public SumExpression(Operands operands) {
        this.operands = operands;
    }

    public static SumExpression from(String value) {
        Matcher matcher = DELIMETER_PATTERN.matcher(value);

        String delimeter = null;
        String expression = value;

        while (matcher.find()) {
            delimeter = matcher.group(CAPTURED_DELIMETER_NAME);
            expression = matcher.replaceFirst(EMPTY);
        }
        if (delimeter == null) {
            delimeter = DEFAULT_DELIMETER;
        }

        return new SumExpression(Operands.from(expression, delimeter));
    }

    public int execute() {
        return operands.sum().getValue();
    }
}

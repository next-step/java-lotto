package calculate.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern p = Pattern.compile("\\/\\/(.)\\\\n(.*)");

    private String operandString;
    private String delimiter;

    public InputView(String input) {
        Matcher m = p.matcher(input);

        if (m.find()) {
            this.delimiter = m.group(1);
            this.operandString = m.group(2);
        }
    }

    public String getOperandString() {
        return operandString;
    }

    public String getDelimiter() {
        return delimiter;
    }
}

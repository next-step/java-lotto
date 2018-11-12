package calculator.parser;

import calculator.utils.ValidationCheck;

public class DefaultParser implements Parsable {

    private static final String DEFAULT_DELIMETER_COLON = ":";
    private static final String DEFAULT_DELIMETER_COMMA = ",";
    private String basicString;

    public DefaultParser(String basicString) {
        this.basicString = basicString;
    }

    @Override
    public String[] getSplitResult() {
        if (ValidationCheck.isBlank(basicString)) {
            return null;
        }

        String[] tmp = basicString.split(DEFAULT_DELIMETER_COLON + "|" +DEFAULT_DELIMETER_COMMA);

        if (ValidationCheck.isNegative(tmp)) {
            throw new RuntimeException();
        }
        return tmp;
    }
}

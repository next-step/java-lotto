package calculator.parser;

import calculator.utils.ValidationCheck;

public class CustomParser implements Parsable {

    private String basicString;

    public CustomParser(String basicString) {
        this.basicString = basicString;
    }

    @Override
    public String[] getSplitResult() {
        try {
            if (ValidationCheck.isBlank(basicString)) {
                return null;
            }

            String[] splitByDelimeter = getSplitByLine(basicString, "\n");
            String delimeter = getDelimeter(splitByDelimeter[0]);

            return splitByDelimeter[1].split(delimeter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String[] getSplitByLine(String basicString, String s) {
        return basicString.split(s);
    }

    private String getDelimeter(String s) {
        return s.substring(s.lastIndexOf('/')+1);
    }
}

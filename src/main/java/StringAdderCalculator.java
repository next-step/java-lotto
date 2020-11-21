import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdderCalculator {
    private int resultOfOperation;
    private List<Operand> operands;

    public StringAdderCalculator() {
        this.operands = new ArrayList<>();
    }

    public int sum(String userInput) {
        if (this.isNullOrEmpty(userInput)) {
            return this.resultOfOperation;
        }

        parseOperands(this.splitOperands(userInput));

        for (Operand operand : this.operands) {
            this.resultOfOperation += operand.getOperand();
        }
        return this.resultOfOperation;
    }

    private void parseOperands(String[] operands) {
        for (String operand : operands) {
            this.operands.add(new Operand(operand));
        }
    }

    private String[] splitOperands(String userInput) {
        final String customRegex = "//(.)\n(.*)";
        final String defaultRegex = ",|:";

        Matcher matcher = Pattern.compile(customRegex).matcher(userInput);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
             return matcher.group(2).split(customDelimiter);
        }

        return userInput.trim().split(defaultRegex);
    }

    private boolean isNullOrEmpty(String userInput) {
        return userInput == null || userInput.isEmpty();
    }
}

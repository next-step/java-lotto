package calculator.exception;

import java.text.MessageFormat;
import java.util.Set;

public class IllegalOperatorExpression extends IllegalArgumentException {
    public IllegalOperatorExpression(String message) {
        super(message);
    }

    public static String formatMessage(String operator, Set<String> operatorSet) {
        return MessageFormat.format("잘못된 수식이 입력되었습니다. (입력 수식: {0}, 허용 수식: {1})", operator, toStringAvailableOperatorSet(operatorSet));
    }

    private static String toStringAvailableOperatorSet(Set<String> operatorSet) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append(" ");
        for (String operator : operatorSet) {
            stringBuilder.append(operator).append(" ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

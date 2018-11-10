package cal;

import java.util.regex.Matcher;

public class StringCalculator {
    public static int add(String expression) {
        StringExpression inputExpression = new StringExpression(expression);
        CustomDelemeter customDelemeter = new CustomDelemeter();
        StringExpressions strNumbers = customDelemeter.getSplitStr(inputExpression);

        Matcher m = inputExpression.getMatcher();
        if (m.find()) {
            customDelemeter = new CustomDelemeter(m.group(1));
            inputExpression = new StringExpression(m.group(2));
            strNumbers = customDelemeter.getSplitStr(inputExpression);
        }
        return ResultNum.getResult(strNumbers);
    }
}

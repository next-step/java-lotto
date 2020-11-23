package lotto;

import java.util.Arrays;
import java.util.List;

public class Expression {
    private final OperandList operandList;

    public Expression(String expression) {
        RawExpression rawExpression = new RawExpression(expression);
        DelimiterList delimiterList = exportDelimiterList(rawExpression);
        this.operandList = exportOperandList(rawExpression, delimiterList);
    }

    private DelimiterList exportDelimiterList(RawExpression rawExpression) {
        DelimiterList delimiterList = new DelimiterList();
        delimiterList.addCustomDelimiter(rawExpression.refineCustomDelimiter());
        return delimiterList;
    }

    private OperandList exportOperandList(RawExpression rawExpression, DelimiterList delimiterList) {
        List<String> splitResult = Arrays.asList(
                rawExpression
                        .refineRawExpression()
                        .split(delimiterList.toSplitRegex()
                        )
        );
        return new OperandList(splitResult);
    }

    public Integer sum() {
        return this.operandList.sum();
    }
}

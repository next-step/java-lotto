package calculator;

import java.util.List;

public class StringCalculator {

    public static int calculate(List<Element> elements) {
        if (elements.get(0).getOperator() != Operator.START) {
            throw new IllegalArgumentException();
        }
        int result = elements.get(0).getOperand();
        for (int i = 1; i < elements.size(); i++) {
            Element element = elements.get(i);
            result = element.getOperator().calculate(result, element.getOperand());
        }
        return result;
    }

}

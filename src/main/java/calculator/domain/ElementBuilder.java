package calculator.domain;

public class ElementBuilder {
    public static Element of(String element) {
        try {
            int value = Integer.parseInt(element);
            return new NumberElement(value);
        } catch (NumberFormatException e) {
            return OperatorBuilder.of(element);
        }
    }

    static class OperatorBuilder {
        public static Operator of(String operator) {
            if (operator.equals("+")) {
                return new Plus();
            }

            if (operator.equals("-")) {
                return new Minus();
            }

            if (operator.equals("*")) {
                return new Multiply();
            }

            if (operator.equals("/")) {
                return new Division();
            }

            throw new IllegalArgumentException("정의 되지 않은 연산자 : " + operator);
        }
    }
}

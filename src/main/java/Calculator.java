public class Calculator {
    public int calculate(String text) {
        return calculate(Digits.of(text), Operators.of(text));
    }

    public int calculate(Digits digits, Operators operators) {
        int result = digits.next();

        while (digits.hasNext() && operators.hasNext()) {
            int nextDigit = digits.next();
            result = operators.next().operate(result, nextDigit);
        }

        return result;
    }
}

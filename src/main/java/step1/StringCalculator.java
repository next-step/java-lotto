package step1;

import java.util.Iterator;

public class StringCalculator {

    private final StringSeparator stringSeparator;

    public StringCalculator(StringSeparator stringSeparator) {
        this.stringSeparator = stringSeparator;
    }

    public int calculate(String input) {
        Iterator<String> numbersAndOperators = stringSeparator.separateByDelimiter(input);

        int prevNum = Integer.parseInt(numbersAndOperators.next());
        while (numbersAndOperators.hasNext()) {
            String operator = numbersAndOperators.next();
            int nextNum = Integer.parseInt(numbersAndOperators.next());

            prevNum = BasicOperators.operate(prevNum, nextNum, operator);
        }
        return prevNum;
    }
}

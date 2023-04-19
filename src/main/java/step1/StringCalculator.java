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
            prevNum = operateNumbers(numbersAndOperators, prevNum);
        }
        return prevNum;
    }

    private int operateNumbers(Iterator<String> numbersAndOperators, int prevNum) {
        String operator = numbersAndOperators.next();
        int nextNum = Integer.parseInt(numbersAndOperators.next());

        return BasicOperators.operate(prevNum, nextNum, operator);
    }
}

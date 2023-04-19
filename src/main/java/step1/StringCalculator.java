package step1;

import java.util.Iterator;
import java.util.List;

public class StringCalculator {

    private final StringSeparator stringSeparator;

    public StringCalculator(StringSeparator stringSeparator) {
        this.stringSeparator = stringSeparator;
    }

    public int calculate(String input) {
        List<String> numbersAndOperators = stringSeparator.separateByDelimiter(input);

        Iterator<String> iterator = numbersAndOperators.iterator();
        int prevNum = Integer.parseInt(iterator.next());
        while (iterator.hasNext()) {
            prevNum = operateNumbers(iterator, prevNum);
        }
        return prevNum;
    }

    private int operateNumbers(Iterator<String> numbersAndOperators, int prevNum) {
        String operator = numbersAndOperators.next();
        int nextNum = Integer.parseInt(numbersAndOperators.next());

        return BasicOperators.operate(prevNum, nextNum, operator);
    }
}

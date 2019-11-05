package calc;

import static calc.InputChecker.checkInput;

public class StringAddCalculator {

    public int add(String input) {
        return add(checkInput(input));
    }

    private int add(Numbers numbers) {
        return numbers.addAll();
    }
}

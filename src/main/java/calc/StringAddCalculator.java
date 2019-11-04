package calc;

public class StringAddCalculator {

    public int add(String input) {
        return add(new InputChecker(input).getNumbers());
    }

    private int add(Numbers numbers) {
        return numbers.addAll();
    }
}

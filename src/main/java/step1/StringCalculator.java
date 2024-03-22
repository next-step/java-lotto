package step1;


public class StringCalculator {

    private final Numbers numbers;
    private final Operators operators;
    private int result;


    public StringCalculator(String string) {
        validateNull(string);
        this.numbers = new Numbers(string);
        this.operators = new Operators(string);
        this.result = 0;
    }


    private static void validateNull(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("문자열이 빈값일 수 없습니다.");
        }
    }

    public int calculate() {
        int index = 0;
        result = numbers.getNumbers(index);
        for (Symbol symbols : operators.getSymbols()) {
            calculatedWith(symbols, numbers.getNumbers(++index));
        }
        return result;
    }

    private void calculatedWith(Symbol symbols, int nextNumber) {
        if (symbols == Symbol.ADD) addNumber(nextNumber);
        if (symbols == Symbol.SUBTRACT) subtractNumber(nextNumber);
        if (symbols == Symbol.MULTIPLY) multiplyNumber(nextNumber);
        if (symbols == Symbol.DIVIDE) divideNumber(nextNumber);
    }

    public void addNumber(int nextNumber) {
        result += nextNumber;
    }

    private void subtractNumber(int nextNumber) {
        result -= nextNumber;
    }

    private void multiplyNumber(int nextNumber) {
        this.result *= nextNumber;
    }

    private void divideNumber(int nextNumber) {
        this.result /= nextNumber;
    }
}

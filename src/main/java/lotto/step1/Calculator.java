package lotto.step1;

public class Calculator {

    private String text;
    private Validation validation;
    private Delimiter delimiter;
    private static final int NEGATIVE_NUMBER_CONDITION = 0;
    private static final int PRINT_NUMBER = 0;

    public Calculator(String text) {
        this.text = text;
        this.delimiter = new Delimiter(text);
        this.validation = new Validation(text);
    }

    public int calculate() {
        if (validation.checkEmptyAndNull()) {
            return PRINT_NUMBER;
        }

        if (validation.checkOnlyNumber()) {
            return printNumber();
        }

        return addNumbers(delimiter.getNumbers());
    }

    public void isNegativeNumber(String number) {
        if (Integer.valueOf(number) < NEGATIVE_NUMBER_CONDITION) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
    
    public int printNumber() {
        return Integer.valueOf(text);
    }
    
    public int addNumbers(String numbers[]) {
        int sum = 0;
        for (String number : numbers) {
            isNegativeNumber(number);
            sum += Integer.valueOf(number);
        }
        return sum;
    }

}

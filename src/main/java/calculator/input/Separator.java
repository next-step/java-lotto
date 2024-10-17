package calculator.input;

public class Separator {

    private final String str;
    private Numbers numbers;
    private Symbols symbols;

    public Separator(final String str) {
        this.str = str;
        this.numbers = new Numbers();
        this.symbols = new Symbols();
    }

    public String[] split() {
        checkStrEmpty(str);
        String[] result = str.split(" ");
        checkValidation(result);
        return result;
    }

    //기호 분리
    public Symbols separateSymbols() {
        return symbols.generateSymbols(split());
    }

    //숫자 분리
    public Numbers separateNumbers() {
        return numbers.generateNumbers(split());
    }

    private static void checkStrEmpty(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("계산식이 빈값입니다.");
        }
    }

    private static void checkValidation(String[] result) {
        if (result.length < 3) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }

        if (result.length % 2 == 0) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
    }

}

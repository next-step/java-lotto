package step1;

public class StringCalculator {
    public int calculate(String str) {
        Numbers numbers = Numbers.of(str);

        return numbers.sum();
    }
}

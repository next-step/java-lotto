package calculator;

public class StringAdder {

    public static int splitAndSum(String source) {
        Numbers numbers = Numbers.of(source);
        return numbers.sum();
    }
}

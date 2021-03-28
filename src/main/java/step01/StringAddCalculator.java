package step01;

public class StringAddCalculator {

    private final Numbers numbers;

    public StringAddCalculator(String numbers) {
        this.numbers = new Numbers(numbers);
    }

    public String sum() {
       return numbers.sum();
    }
}

package StringCalculator;

public class Addition {

    public Addition() {

    }

    public WholeNumber addAll(WholeNumbers numbers) {
        int sum = numbers.getValue().stream().mapToInt(WholeNumber::getValue).sum();
        return new WholeNumber(sum);
    }
}

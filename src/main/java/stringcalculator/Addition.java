package stringcalculator;

public class Addition {

    public WholeNumber addAll(WholeNumbers numbers) {
        int sum = numbers.value().stream().mapToInt(WholeNumber::value).sum();
        return new WholeNumber(sum);
    }
}

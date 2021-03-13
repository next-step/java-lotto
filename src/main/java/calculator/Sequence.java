package calculator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sequence {

    private final List<Integer> elements;

    public Sequence(List<String> strSequence) {
        elements = strSequence.stream()
                              .map(this::parseInt)
                              .collect(Collectors.toList());
    }

    private int parseInt(String strNumber) {
        int number = Integer.parseInt(strNumber);

        validatePositiveInteger(number);

        return number;
    }

    private void validatePositiveInteger(int number) {
        if (number < 0) {
            throw new NegativeIntegerElementException();
        }
    }

    public int sum() {
        return elements.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sequence)) return false;
        Sequence sequence = (Sequence) o;
        return Objects.equals(elements, sequence.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}

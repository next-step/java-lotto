package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateNumber {
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final int MINIMUM_LOTTO_NUMBER = 1;

    private List<Number> generatedNumber;

    public GenerateNumber() {
        generatedNumber = generateNumbers();
    }

    public List<Number> generateNumbers() {
        return IntStream
                .rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenerateNumber)) return false;
        GenerateNumber that = (GenerateNumber) o;
        return Objects.equals(generatedNumber, that.generatedNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generatedNumber);
    }
}

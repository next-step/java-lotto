package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateLottoNumber {
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final int MINIMUM_LOTTO_NUMBER = 1;

    private List<Integer> generatedNumber;

    public GenerateLottoNumber() {
        generatedNumber = shuffleNumbers(generateNumbers());
    }

    public List<Integer> generateNumbers() {
        return IntStream
                .rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getGeneratedNumber() {
        return new ArrayList<>(generatedNumber);
    }

    private List<Integer> shuffleNumbers(List<Integer> generatedNumber) {
        Collections.shuffle(generatedNumber);
        return generatedNumber;
    }

    public Set<Integer> getLottoNumbers() {
        return generatedNumber.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenerateLottoNumber)) return false;
        GenerateLottoNumber that = (GenerateLottoNumber) o;
        return Objects.equals(generatedNumber, that.generatedNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generatedNumber);
    }
}

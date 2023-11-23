package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private final Set<Integer> numbers;

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private final List<Integer> generateNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).boxed().collect(Collectors.toList());

    public LottoNumber() {
        this.numbers = getGenerateNumbers();
    }

    public LottoNumber(List<Integer> list) {
        this.numbers = new HashSet<>(list);
    }

    public List<Integer> getNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>((numbers));
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    private Set<Integer> getGenerateNumbers() {
        Collections.shuffle(generateNumbers);
        Set<Integer> result = new HashSet<>(generateNumbers.subList(0, LOTTO_COUNT));
        return result;
    }
}

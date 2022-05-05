package lotto.domain;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Numbers {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    private final List<Integer> numbers = new ArrayList<>();
    private final List<Integer> lottoNumbers = new ArrayList<>();

    public Numbers() {
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        lottoNumbers.addAll(numbers.subList(0, 6));
        Collections.sort(lottoNumbers);
    }

    public Numbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            lottoNumbers.add(number);
        }
        Collections.sort(lottoNumbers);
    }

    public int size() {
        return lottoNumbers.size();
    }

    public List<Integer> contains(List<Integer> prevLottoNumbers) {
        return lottoNumbers.stream()
                .filter(lottoNumber -> prevLottoNumbers.stream().anyMatch(Predicate.isEqual(lottoNumber)))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers = (Numbers) o;
        return Arrays.equals(lottoNumbers.toArray(), numbers.lottoNumbers.toArray());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

}

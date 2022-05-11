package lotto.domain;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Numbers {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    private List<Integer> lottoNumbers = new ArrayList<>();

    public Numbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        this.lottoNumbers = numbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }

    public Numbers(List<Integer> numbers) {
        numbers.stream()
                .forEach(number -> lottoNumbers.add(number));
        Collections.sort(lottoNumbers);
    }

    public int matchCount(List<Integer> winningNumbers) {
        List<Integer> collect = lottoNumbers.stream()
                .filter(lottoNumber -> winningNumbers.stream().anyMatch(Predicate.isEqual(lottoNumber)))
                .collect(Collectors.toList());
        return collect.size();
    }


    public boolean contains(int bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
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

package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> numbers;

    public LottoNumbers(String numbers) {
        this(Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet())
        );
    }

    public LottoNumbers(Set<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("Lotto requires " + LOTTO_SIZE + " numbers.");
        }

        this.numbers = numbers;
    }

    public Integer intersectCount(LottoNumbers other) {
        Set<LottoNumber> intersection = new HashSet<>(numbers);
        intersection.retainAll(other.numbers);
        return intersection.size();
    }

    @Override
    public String toString() {
        List<LottoNumber> numberList = new ArrayList<>(numbers);
        Collections.sort(numberList);
        return numberList.toString();
    }
}

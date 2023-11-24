package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<LottoNumber> CANDIDATE_NUMBERS = IntStream.range(LottoNumber.lowerBound(), LottoNumber.upperBound() + 1)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
    private static final String ERR_VALID_NUMBER_COUNT = "There must be a total of 6 lotto numbers.";

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        if (isNotValidSize(numbers)) {
            throw new IllegalArgumentException(ERR_VALID_NUMBER_COUNT);
        }
        this.numbers = numbers;
    }

    private static boolean isNotValidSize(List<LottoNumber> numbers) {
        return numbers.size() != LOTTO_NUMBER_COUNT;
    }

    public static LottoNumbers of(List<Integer> numbers) {
        return new LottoNumbers(numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public static LottoNumbers generate() {
        Collections.shuffle(CANDIDATE_NUMBERS);
        List<LottoNumber> numbers = CANDIDATE_NUMBERS.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        return new LottoNumbers(new ArrayList<>(numbers));
    }

    public int matchNumbers(LottoNumbers targets) {
        return (int) this.numbers.stream()
                .filter(number -> targets.containsNumber(number))
                .count();
    }

    private boolean containsNumber(LottoNumber number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}

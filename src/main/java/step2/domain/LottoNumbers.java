package step2.domain;

import step2.exception.InvalidLottoSizeException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static step2.domain.LottoNumber.allLottoNumbers;

public class LottoNumbers {

    private static final int LOTTO_MAX_SIZE = 6;
    private static final int DEFAULT_FROM_INDEX = 0;

    private final Set<LottoNumber> numbers;

    public LottoNumbers() {
        this(automaticLottoNumbers());
    }

    public LottoNumbers(List<Integer> numbers) {
        this(numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toSet()));
    }

    private LottoNumbers(Set<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static Set<LottoNumber> automaticLottoNumbers() {
        Collections.shuffle(allLottoNumbers());
        return new HashSet<>(allLottoNumbers().subList(DEFAULT_FROM_INDEX, LOTTO_MAX_SIZE));
    }

    private void validate(Set<LottoNumber> numbers) {
        if (numbers.size() > LOTTO_MAX_SIZE) {
            throw new InvalidLottoSizeException();
        }
    }

    public int numberOfMatches(LottoNumbers lottoNumbers) {
        return Math.toIntExact(this.numbers.stream()
            .filter(lottoNumbers::contain)
            .count());
    }

    public boolean contain(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public List<Integer> numbers() {
        return this.numbers.stream()
            .map(LottoNumber::number)
            .collect(Collectors.toList());
    }

}

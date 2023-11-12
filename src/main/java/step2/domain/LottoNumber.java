package step2.domain;

import step2.exception.InvalidLottoNumberCountException;

import java.util.*;

public class LottoNumber {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MAX_COUNT = 6;
    private static final int ZERO = 0;
    private static final List<Integer> defaultNumbers = defaultNumbers();

    private final Set<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        validate(uniqueNumbers);
        this.numbers = uniqueNumbers;
    }

    public LottoNumber() {
        this(lottoNumbers());
    }

    private void validate(Set<Integer> numbers) {
        if (numbers.size() > LOTTO_MAX_COUNT) {
            throw new InvalidLottoNumberCountException();
        }
    }

    private static List<Integer> defaultNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= LOTTO_MAX_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static List<Integer> lottoNumbers() {
        Collections.shuffle(defaultNumbers);
        return defaultNumbers.subList(ZERO, LOTTO_MAX_COUNT);
    }

    public List<Integer> numbers() {
        return new ArrayList<>(this.numbers);
    }

}

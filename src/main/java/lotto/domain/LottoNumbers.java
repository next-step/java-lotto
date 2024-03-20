package lotto.domain;

import lotto.exception.IllegalLottoNumbersException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final int LOTTO_RANGE_FROM = 1;
    private static final int LOTTO_RANGE_TO = 45;

    private static final int NUMBER_INDEX_FROM = 0;
    private static final int NUMBER_INDEX_TO = 6;

    private static final int SIZE = NUMBER_INDEX_TO - NUMBER_INDEX_FROM;

    private final List<Integer> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = IntStream.rangeClosed(LOTTO_RANGE_FROM, LOTTO_RANGE_TO)
                .boxed()
                .collect(Collectors.toList());
    }

    public void validate(List<Integer> numbers) throws IllegalLottoNumbersException {
        if (notContainsAll(numbers) || notSizeMatch(numbers)) {
            throw new IllegalLottoNumbersException(numbers);
        }
    }

    private boolean notContainsAll(List<Integer> numbers) {
        return !this.lottoNumbers.containsAll(numbers);
    }

    private boolean notSizeMatch(List<Integer> numbers) {
        return SIZE != numbers.size();
    }

    public List<Integer> auto() {
        Collections.shuffle(this.lottoNumbers);
        return new ArrayList<>(getSubList());
    }

    private List<Integer> getSubList() {
        return this.lottoNumbers.subList(NUMBER_INDEX_FROM, NUMBER_INDEX_TO);
    }

}

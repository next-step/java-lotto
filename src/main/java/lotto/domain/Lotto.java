package lotto.domain;

import lotto.strategy.NumberStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private List<Integer> lottoNumbers;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
    }

    public void generateLottoNumber(NumberStrategy numberStrategy) {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < LOTTO_NUMBER_SIZE) {
            lottoNumbers.add(numberStrategy.create());
        }
        sortLotto(numbers);
    }

    private boolean isDuplicateNumber(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }

    private void sortLotto(Set<Integer> numbers) {
        lottoNumbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}

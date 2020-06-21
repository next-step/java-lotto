package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private List<LottoNumber> numbers;

    public Lotto(List<Integer> inputNumbers) {

        this.numbers = new ArrayList<>();

        if (isDuplicate(inputNumbers)) {
            throw new IllegalArgumentException();
        }

        for (Integer number : inputNumbers) {
            this.numbers.add(new LottoNumber(number));
        }

    }

    private boolean isDuplicate(List<Integer> inputNumbers) {
        Set<Integer> checkNumbers = new HashSet<>(inputNumbers);
        return checkNumbers.size() != LOTTO_SIZE;
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(number -> number.getNumber())
                .collect(Collectors.toList());
    }

    public int matchCount(Lotto winningLotto) {

        int count = 0;

        for (int winnerNumber : winningLotto.getNumbers()) {
            if (this.getNumbers().contains(winnerNumber)) {
                count += 1;
            }
        }
        return count;

    }

}

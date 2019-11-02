package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {

    private final List<Integer> numbers;

    LottoNumber() {
        this.numbers = getShuffledNumbers();
    }

    // test 용
    LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private List<Integer> getShuffledNumbers() {
        List<Integer> numberCandidates = LottoNumberPool.getNumbers();

        Collections.shuffle(numberCandidates);

        return numberCandidates.stream().limit(6).sorted().collect(Collectors.toList());
    }

    public long matchNumberCount(List<Integer> winnerNumbers) {
        return winnerNumbers.stream().filter(numbers::contains).count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

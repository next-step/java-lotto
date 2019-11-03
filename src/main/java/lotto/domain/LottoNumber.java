package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {

    private final List<Integer> numbers;

    LottoNumber() {
        this.numbers = getShuffledNumbers();
    }

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private List<Integer> getShuffledNumbers() {
        List<Integer> numberCandidates = LottoNumberPool.getNumbers();

        Collections.shuffle(numberCandidates);

        return numberCandidates.stream().limit(6).sorted().collect(Collectors.toList());
    }

    public LottoRank getRank(LottoNumber winningNumber) {
        return LottoRank.find(matchNumberCount(winningNumber));
    }

    private long matchNumberCount(LottoNumber winnerLottoNumber) {
        return winnerLottoNumber.getNumbers().stream().filter(numbers::contains).count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

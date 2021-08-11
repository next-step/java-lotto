package lotto.domain;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers.generateRandomNumbers();
    }

    public int getMatchCount(LottoNumbers numbers) {
        return (int) numbers.getWinningNumbers().stream().filter(n -> this.numbers.contains(n)).count();
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

}

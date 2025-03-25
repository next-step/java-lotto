package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Rank rank;

    public Lotto(List<Integer> numbers) {
        this.numbers = List.copyOf(numbers);
        this.rank = Rank.PENDING;
    }

    public Lotto(Rank rank) {
        this.numbers = new ArrayList<>();
        this.rank = rank;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void checkLottoResult(List<Integer> winningNumbers) {
        int matchCount = 0;

        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        rank = Rank.getRankByMatchCount(matchCount);
    }

    public Rank getRank() {
        return rank;
    }

    public int getPrize() {
        return rank.getPrize();
    }

}

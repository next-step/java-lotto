package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final List<Integer> numbers;
    private long matchingScore;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public long getMatchingScore() {
        return this.matchingScore;
    }

    public void saveMatchingScore(long matchingScore) {
        this.matchingScore = matchingScore;
    }
}

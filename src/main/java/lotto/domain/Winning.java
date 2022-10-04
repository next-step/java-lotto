package lotto.domain;

public class Winning {
    private final int count;
    private final Prize prize;
    private final LottoNumbers numbers;

    public Winning(int matchCount, Prize prize, LottoNumbers matchNumbers) {
        this.count = matchCount;
        this.prize = prize;
        this.numbers = matchNumbers;
    }

    public int matchCount() {
        return count;
    }

    public int numberCount() {
        return numbers.count();
    }

    public long prize() {
        return prize.value();
    }
}

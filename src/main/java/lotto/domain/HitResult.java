package lotto.domain;

public class HitResult {
    private final Numbers numbers;
    private final Prize prize;

    public HitResult(Numbers numbers, WinNumbers winNumbers) {
        this.numbers = numbers;
        this.prize = findPrize(winNumbers);
    }

    private Prize findPrize(WinNumbers winNumbers) {
        HitCount hitCount = winNumbers.hitNumberCount(numbers);
        return Prize.findPrize(hitCount);
    }

    public Prize getPrize() {
        return prize;
    }
}

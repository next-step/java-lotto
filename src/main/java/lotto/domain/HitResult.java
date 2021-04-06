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

    public boolean equalPrize(Prize prize) {
        return this.prize.equals(prize) ? true : false;
    }

    public int getPrizeMoney() {
        return prize.prizeMoney();
    }

    public int getPrizeHitCount() {
        return prize.getHitCount().getHitCount();
    }
}

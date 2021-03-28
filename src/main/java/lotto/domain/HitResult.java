package lotto.domain;

public class HitResult {
    private final Numbers numbers;
    private final WinNumbers winNumbers;

    public HitResult(Numbers numbers, WinNumbers winNumbers) {
        this.numbers = numbers;
        this.winNumbers = winNumbers;
    }

    public HitCount hitCount() {
        return winNumbers.hitNumberCount(numbers);
    }

    public HitMoney hitMoney() {
        Prize prize = Prize.findPrize(hitCount());

        if (prize == null) {
            return new HitMoney(0);
        }

        return prize.getPrizeMoney();
    }

    public boolean isHitPrize(Prize prize) {
        return prize.getHitCount()
                .equals(hitCount());
    }
}

package lotto.domain;

public class Lotto {

    public static final int PRICE = 1000;

    private final LottoNumbers numbers;

    public Lotto(LottoNumberSelectRule numberSelectRule) {
        this.numbers = numberSelectRule.select();
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }

    public Rank checkResult(WinningNumbers winningNumbers, int bonusNumber) {
        long matchedCount = calculateMatchedCount(winningNumbers);
        long matchedBonusCount = calculateMatchedBonusCount(bonusNumber);

        return Rank.findByMatchedCount(matchedCount, matchedBonusCount);
    }

    private long calculateMatchedBonusCount(int bonusNumber) {
        return numbers.countMatches(bonusNumber);
    }

    private long calculateMatchedCount(WinningNumbers winningNumbers) {
        return numbers.countMatches(winningNumbers);
    }
}

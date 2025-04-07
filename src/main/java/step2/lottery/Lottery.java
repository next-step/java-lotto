package step2.lottery;

import step2.winning.PrizeWinningNumber;
import step2.winning.Winning;

import java.util.Set;

public class Lottery {
    private final Set<LotteryNumber> lottoNumbers;

    public Lottery(Set<LotteryNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
    public Winning matchWith(PrizeWinningNumber prize) {
        int matchCount = prize.matchCount(lottoNumbers);
        boolean bonus = (matchCount == 5 && prize.isMatchBounus(lottoNumbers));
        return Winning.valueOf(matchCount, bonus);
    }

    public Set<LotteryNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Lottery) {
            Lottery other = (Lottery) obj;
            return lottoNumbers.equals(other.lottoNumbers);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return lottoNumbers.hashCode();
    }
}

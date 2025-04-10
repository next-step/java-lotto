package step2.lottery;

import step2.winning.PrizeWinningNumber;
import step2.winning.Winning;

import java.util.Set;

public class Lottery extends AbstractLottery {
    public Lottery(Set<LotteryNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public Winning matchWith(PrizeWinningNumber prize) {
        int matchCount = prize.matchCount(lottoNumbers);
        boolean bonus = (matchCount == 5 && prize.isMatchBounus(lottoNumbers));
        return Winning.valueOf(matchCount, bonus);
    }
}

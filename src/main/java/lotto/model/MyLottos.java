package lotto.model;

import java.util.Collections;
import java.util.List;

import static lotto.model.Rank.*;

public class MyLottos {
    private static final long PRICE_TO_BUY_ONE_LOTTO = 1000l;

    private List<LottoNumbers> lottoNumbers;

    public MyLottos(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public long findCountOfNumMatching(WinningLottoNumbers winningLottoNumbers, Rank rank, int bonusBall) {
        if (rank.equals(SECOND)) {
            return findCountOfSecond(winningLottoNumbers, bonusBall);
        }
        if (rank.equals(THIRD)) {
            return findCountOfThird(winningLottoNumbers, bonusBall);
        }
        return findCountOfNumMatchingExceptThirdAndSecond(winningLottoNumbers, rank);
    }

    private long findCountOfSecond(WinningLottoNumbers winningLottoNumbers, int bonusBall) {
        return lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.hasBonusBall(bonusBall))
                .map(lottoNumber -> lottoNumber.findHowManyMatch(winningLottoNumbers))
                .filter(matchCount -> matchCount == SECOND.getMatchCount())
                .count();
    }

    private long findCountOfThird(WinningLottoNumbers winningLottoNumbers, int bonusBall) {
        return lottoNumbers.stream()
                .filter(lottoNumber -> !lottoNumber.hasBonusBall(bonusBall))
                .map(lottoNumber -> lottoNumber.findHowManyMatch(winningLottoNumbers))
                .filter(matchCount -> matchCount == THIRD.getMatchCount())
                .count();
    }

    private long findCountOfNumMatchingExceptThirdAndSecond(WinningLottoNumbers winningLottoNumbers, Rank rank) {
        return lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.findHowManyMatch(winningLottoNumbers))
                .filter(count -> rank.getMatchCount() == count)
                .count();
    }

    public Money calculateAllPrizeMoney(WinningLottoNumbers winningLottoNumbers, int bonusBall) {
        long money = 0;

        for (Rank rank : Rank.values()) {
            Money prizeMoney = calculatePrizeMoney(winningLottoNumbers, rank, bonusBall);
            money += prizeMoney.getMoney();
        }

        return new Money(money);
    }

    private Money calculatePrizeMoney(WinningLottoNumbers winningLottoNumbers, Rank rank, int bonusBall) {
        return rank.calculatePrizeMoney(findCountOfNumMatching(winningLottoNumbers, rank, bonusBall));
    }

    public double calculateEarningRate(WinningLottoNumbers winningLottoNumbers, int bonusBall) {
        Money earningMoney = calculateAllPrizeMoney(winningLottoNumbers, bonusBall);
        return findEarningRate(earningMoney);
    }

    private double findEarningRate(Money earningMoney) {
        return earningMoney.getMoney() / findInputMoney() * 100;
    }

    private double findInputMoney() {
        return lottoNumbers.size() * PRICE_TO_BUY_ONE_LOTTO;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return this.lottoNumbers;
    }
}
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

    public long findCountOfNumMatching(List<Integer> winningLotto, Rank rank, int bonusBall) {
        if (rank.equals(SECOND)) {
            return findCountOfSecond(winningLotto, bonusBall);
        }
        if (rank.equals(THIRD)) {
            return findCountOfThird(winningLotto, bonusBall);
        }
        return findCountOfNumMatchingExceptThirdAndSecond(winningLotto, rank);
    }

    private long findCountOfSecond(List<Integer> winningLotto, int bonusBall) {
        return lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.hasBonusBall(bonusBall))
                .map(lottoNumber -> lottoNumber.findHowManyMatch(winningLotto))
                .filter(matchCount -> matchCount == SECOND.getMatchCount())
                .count();
    }

    private long findCountOfThird(List<Integer> winningLotto, int bonusBall) {
        return lottoNumbers.stream()
                .filter(lottoNumber -> !lottoNumber.hasBonusBall(bonusBall))
                .map(lottoNumber -> lottoNumber.findHowManyMatch(winningLotto))
                .filter(matchCount -> matchCount == THIRD.getMatchCount())
                .count();
    }

    private long findCountOfNumMatchingExceptThirdAndSecond(List<Integer> winningLotto, Rank rank) {
        return lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.findHowManyMatch(winningLotto))
                .filter(count -> rank.getMatchCount() == count)
                .count();
    }

    public Money calculateAllPrizeMoney(List<Integer> winningLotto, int bonusBall) {
        long money = 0;

        for (Rank rank : Rank.values()) {
            Money prizeMoney = calculatePrizeMoney(winningLotto, rank, bonusBall);
            money += prizeMoney.getMoney();
        }

        return new Money(money);
    }

    private Money calculatePrizeMoney(List<Integer> winningLotto, Rank rank, int bonusBall) {
        return rank.calculatePrizeMoney(findCountOfNumMatching(winningLotto, rank, bonusBall));
    }

    public double calculateEarningRate(List<Integer> winningLotto, int bonusBall) {
        Money earningMoney = calculateAllPrizeMoney(winningLotto, bonusBall);
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
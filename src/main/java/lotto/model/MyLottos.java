package lotto.model;

import java.util.Collections;
import java.util.List;

import static lotto.model.MatchingResult.*;

public class MyLottos {
    private static final long PRICE_TO_BUY_ONE_LOTTO = 1000l;

    private List<LottoNumbers> lottoNumbers;

    public MyLottos(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public long findCountOfNumMatching(List<Integer> winningLotto, MatchingResult matchingResult, int bonusBall) {
        if (matchingResult.equals(SECOND)) {
            return findCountOfSecond(winningLotto, bonusBall);
        }
        if (matchingResult.equals(THIRD)) {
            return findCountOfThird(winningLotto, bonusBall);
        }
        return findCountOfNumMatchingExceptThirdAndSecond(winningLotto, matchingResult);
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

    private long findCountOfNumMatchingExceptThirdAndSecond(List<Integer> winningLotto, MatchingResult matchingResult) {
        return lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.findHowManyMatch(winningLotto))
                .filter(count -> matchingResult.getMatchCount() == count)
                .count();
    }

    public Money calculateAllPrizeMoney(List<Integer> winningLotto, int bonusBall) {
        long money = 0;

        for (MatchingResult matchingResult : MatchingResult.values()) {
            Money prizeMoney = calculatePrizeMoney(winningLotto, matchingResult, bonusBall);
            money += prizeMoney.getMoney();
        }

        return new Money(money);
    }

    private Money calculatePrizeMoney(List<Integer> winningLotto, MatchingResult matchingResult, int bonusBall) {
        return matchingResult.calculatePrizeMoney(findCountOfNumMatching(winningLotto, matchingResult, bonusBall));
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
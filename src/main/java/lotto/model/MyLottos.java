package lotto.model;

import java.util.Collections;
import java.util.List;

import static lotto.model.Result.*;

public class MyLottos {
    private static final long PRICE_TO_BUY_ONE_LOTTO = 1000l;

    private List<LottoNumbers> lottoNumbers;

    public MyLottos(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public long findCountOfNumMatching(List<Integer> winningLotto, Result result, int bonusBall) {
        if (result.equals(SECOND)) {
            return findCountOfSecond(winningLotto, bonusBall);
        }
        if (result.equals(THIRD)) {
            return findCountOfThird(winningLotto, bonusBall);
        }
        return findCountOfNumMatchingExceptThirdAndSecond(winningLotto, result);
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

    private long findCountOfNumMatchingExceptThirdAndSecond(List<Integer> winningLotto, Result result) {
        return lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.findHowManyMatch(winningLotto))
                .filter(count -> result.getMatchCount() == count)
                .count();
    }

    public Money calculateAllPrizeMoney(List<Integer> winningLotto, int bonusBall) {
        long money = 0;

        for (Result result : Result.values()) {
            Money prizeMoney = calculatePrizeMoney(winningLotto, result, bonusBall);
            money += prizeMoney.getMoney();
        }

        return new Money(money);
    }

    private Money calculatePrizeMoney(List<Integer> winningLotto, Result result, int bonusBall) {
        return result.calculatePrizeMoney(findCountOfNumMatching(winningLotto, result, bonusBall));
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
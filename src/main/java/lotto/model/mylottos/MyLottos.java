package lotto.model.mylottos;

import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.winninglotto.WinningLotto;

import java.util.Collections;
import java.util.List;

import static lotto.model.Rank.SECOND;
import static lotto.model.Rank.THIRD;

public class MyLottos {
    private static final long PRICE_TO_BUY_ONE_LOTTO = 1000l;

    private List<LottoNumbers> lottoNumbers;

    public MyLottos(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public long findCountOfNumMatching(WinningLotto winningLotto, Rank rank) {
        if (rank.equals(SECOND)) {
            return findCountOfSecond(winningLotto);
        }
        if (rank.equals(THIRD)) {
            return findCountOfThird(winningLotto);
        }
        return findCountOfNumMatchingExceptThirdAndSecond(winningLotto, rank);
    }

    private long findCountOfSecond(WinningLotto winningLotto) {
        long count1 = lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.hasBonusBall(winningLotto.getBonusNum()))
                .map(lottoNumber -> lottoNumber.findHowManyMatch(winningLotto))
                .filter(matchCount -> matchCount == SECOND.getMatchCount())
                .count();
        return count1;
    }

    private long findCountOfThird(WinningLotto winningLotto) {
        return lottoNumbers.stream()
                .filter(lottoNumber -> !lottoNumber.hasBonusBall(winningLotto.getBonusNum()))
                .map(lottoNumber -> lottoNumber.findHowManyMatch(winningLotto))
                .filter(matchCount -> matchCount == THIRD.getMatchCount())
                .count();
    }

    private long findCountOfNumMatchingExceptThirdAndSecond(WinningLotto winningLotto, Rank rank) {
        return lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.findHowManyMatch(winningLotto))
                .filter(count -> rank.getMatchCount() == count)
                .count();
    }

    public Money calculateAllPrizeMoney(WinningLotto winningLotto) {
        long money = 0;

        for (Rank rank : Rank.values()) {
            Money prizeMoney = calculatePrizeMoney(winningLotto, rank);
            money += prizeMoney.getMoney();
        }

        return new Money(money);
    }

    private Money calculatePrizeMoney(WinningLotto winningLotto, Rank rank) {
        return rank.calculatePrizeMoney(findCountOfNumMatching(winningLotto, rank));
    }

    public double calculateEarningRate(WinningLotto winningLotto) {
        Money earningMoney = calculateAllPrizeMoney(winningLotto);
        return findEarningRate(earningMoney);
    }

    private double findEarningRate(Money earningMoney) {
        return earningMoney.getMoney() / findInputMoney() * 100;
    }

    private double findInputMoney() {
        return lottoNumbers.size() * PRICE_TO_BUY_ONE_LOTTO;
    }

    public int findLottoCount() {
        return lottoNumbers.size();
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }
}
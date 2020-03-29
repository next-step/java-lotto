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

    public long findCountOfNumMatching(List<Integer> winningLotto, MatchingResult matchingResult) {
        return lottoNumbers.stream()
                .map(lottoNumbers -> lottoNumbers.findHowManyMatch(winningLotto))
                .filter(count -> matchingResult.getMatchCount() == count)
                .count();
    }

    public Money calculateAllPrizeMoney(List<Integer> winningLotto) {
        Money threeMatchMoney = calculatePrizeMoney(winningLotto, THREE);
        Money fourMatchMoney = calculatePrizeMoney(winningLotto, FOUR);
        Money fiveMatchMoney = calculatePrizeMoney(winningLotto, FIVE);
        Money sixMatchMoney = calculatePrizeMoney(winningLotto, SIX);
        return threeMatchMoney.add(fourMatchMoney).add(fiveMatchMoney).add(sixMatchMoney);
    }

    private Money calculatePrizeMoney(List<Integer> winningLotto, MatchingResult matchingResult) {
        return matchingResult.calculatePrizeMoney(findCountOfNumMatching(winningLotto, matchingResult));
    }

    public double calculateEarningRate(List<Integer> winningLotto) {
        Money earningMoney = calculateAllPrizeMoney(winningLotto);
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
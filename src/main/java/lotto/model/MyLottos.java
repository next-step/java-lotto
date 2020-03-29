package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.MatchingResult.*;

public class MyLottos {
    private static final int THREE_NUM_MATCH_WITH_WINNING_LOTTO = 3;
    private static final int FOUR_NUM_MATCH_WITH_WINNING_LOTTO = 4;
    private static final int FIVE_NUM_MATCH_WITH_WINNING_LOTTO = 5;
    private static final int SIX_NUM_MATCH_WITH_WINNING_LOTTO = 6;
    private static final long PRICE_TO_BUY_ONE_LOTTO = 1000l;

    private List<LottoNumbers> lottoNumbers;

    public MyLottos(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public List<Integer> findHowManyMatchWith(List<Integer> winningLotto){
        return lottoNumbers.stream()
                .map(lottoNumbers -> lottoNumbers.findHowManyMatch(winningLotto))
                .collect(Collectors.toList());
    }

    public long findCountOfThreeNumMatching(List<Integer> winningLotto) {
        return lottoNumbers.stream()
                .map(lottoNumbers -> lottoNumbers.findHowManyMatch(winningLotto))
                .filter(count -> THREE_NUM_MATCH_WITH_WINNING_LOTTO == count)
                .count();
    }

    public long findCountOfFourNumMatching(List<Integer> winningLotto) {
        return lottoNumbers.stream()
                .map(lottoNumbers -> lottoNumbers.findHowManyMatch(winningLotto))
                .filter(count -> FOUR_NUM_MATCH_WITH_WINNING_LOTTO == count)
                .count();
    }

    public long findCountOfFiveNumMatching(List<Integer> winningLotto) {
        return lottoNumbers.stream()
                .map(lottoNumbers -> lottoNumbers.findHowManyMatch(winningLotto))
                .filter(count -> FIVE_NUM_MATCH_WITH_WINNING_LOTTO == count)
                .count();
    }

    public long findCountOfSixNumMatching(List<Integer> winningLotto) {
        return lottoNumbers.stream()
                .map(lottoNumbers -> lottoNumbers.findHowManyMatch(winningLotto))
                .filter(count -> SIX_NUM_MATCH_WITH_WINNING_LOTTO == count)
                .count();
    }

    public Money calculatePrizeMoney(List<Integer> winningLotto) {
        Money money = THREE.calculatePrizeMoney(this.findCountOfThreeNumMatching(winningLotto));
        Money money2 = FOUR.calculatePrizeMoney(this.findCountOfFourNumMatching(winningLotto));
        Money money3 = FIVE.calculatePrizeMoney(this.findCountOfFiveNumMatching(winningLotto));
        Money money4 = SIX.calculatePrizeMoney(this.findCountOfSixNumMatching(winningLotto));
        return money.add(money2).add(money3).add(money4);
    }

    public double calculateEarningRate(List<Integer> winningLotto) {
        Money earningMoney = calculatePrizeMoney(winningLotto);
        if (earningMoney == null) {
            return 0;
        }
        return ((double) earningMoney.getMoney() / (this.lottoNumbers.size() * PRICE_TO_BUY_ONE_LOTTO)) * 100;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return this.lottoNumbers;
    }
}
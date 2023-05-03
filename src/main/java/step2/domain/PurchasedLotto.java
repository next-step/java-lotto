package step2.domain;

import static step2.domain.Ranking.SECOND;
import static step2.domain.Ranking.THIRD;

import java.util.List;
import java.util.stream.Collectors;

public class PurchasedLotto {

    private final List<Lotto> lottoList;

    public PurchasedLotto(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public String getRateOfReturn(int money) {
        return String.format("%.2f", (double) getSumOfWinningMoney() / (double) money);
    }

    public int getCountOfRank(Ranking ranking) {
        return (int) lottoList.stream().filter(lotto -> lotto.getRanking() == ranking).count();
    }

    public List<Lotto> get() {
        return this.lottoList;
    }

    public void applyRanking(WinningNumbers winningNumbers) {
        for (Lotto lotto : this.lottoList) {
            int matchedCount = getMatchedCount(winningNumbers, lotto);
            Ranking ranking = Ranking.match(matchedCount);
            lotto.rank(ranking);
        }
    }

    public void matchSecondOrThird(BonusNumber bonusNumber) {
        List<Lotto> secondCandidate =
            lottoList.stream().filter(Lotto::isSecond).collect(Collectors.toList());

        for (Lotto lotto : secondCandidate) {
            boolean isContained = bonusNumber.isContained(lotto);
            prizeSecondOrThird(lotto, isContained);
        }
    }

    private void prizeSecondOrThird(Lotto lotto, boolean isContained) {
        if (isContained) {
            lotto.rank(SECOND);
            return;
        }
        lotto.rank(THIRD);
    }

    private int getMatchedCount(WinningNumbers winningNumbers, Lotto lotto) {
        return lotto.match(winningNumbers);
    }

    private int getSumOfWinningMoney() {
        return lottoList.stream().mapToInt(Lotto::getPrizedMoney).sum();
    }
}

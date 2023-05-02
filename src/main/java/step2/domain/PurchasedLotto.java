package step2.domain;

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

    public void matchRanking(WinningNumbers winningNumbers) {
        for (Lotto lotto : this.lottoList) {
            int matchedCount = getMatchedCount(winningNumbers, lotto);
            Ranking ranking = Ranking.match(matchedCount);
            lotto.rank(ranking);
        }
    }

    public List<Lotto> findSecondCandidate() {
        return lottoList.stream().filter(Lotto::isSecond).collect(Collectors.toList());
    }

    private int getMatchedCount(WinningNumbers winningNumbers, Lotto lotto) {
        return lotto.match(winningNumbers);
    }

    private int getSumOfWinningMoney() {
        return lottoList.stream().mapToInt(Lotto::getPrizedMoney).sum();
    }
}

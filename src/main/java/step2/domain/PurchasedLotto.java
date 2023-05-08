package step2.domain;

import java.util.ArrayList;
import java.util.List;

public final class PurchasedLotto {

    private final List<Lotto> purchasedLottoList;

    public PurchasedLotto(List<Lotto> purchasedLottoList) {
        this.purchasedLottoList = purchasedLottoList;
    }

    public String getRateOfReturn(int money) {
        return String.format("%.2f", (double) getSumOfWinningMoney() / (double) money);
    }

    public int getCountOfRank(Ranking ranking) {
        return (int) purchasedLottoList.stream()
            .filter(lotto -> lotto.getRanking() == ranking)
            .count();
    }

    public List<Lotto> get() {
        return this.purchasedLottoList;
    }

    public PurchasedLotto applyRanking(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<Lotto> rankedLottos = new ArrayList<>();

        for (Lotto lotto : this.purchasedLottoList) {
            boolean isContained = bonusNumber.isContained(lotto);
            int matchedCount = getMatchedCount(winningNumbers, lotto);
            Ranking ranking = Ranking.match2(matchedCount, isContained);
            rankedLottos.add(new Lotto(lotto.getDetailNumbers(), ranking));
        }

        return new PurchasedLotto(rankedLottos);
    }

    private int getMatchedCount(WinningNumbers winningNumbers, Lotto lotto) {
        return lotto.match(winningNumbers);
    }

    private long getSumOfWinningMoney() {
        return purchasedLottoList.stream().mapToInt(Lotto::getPrizedMoney).sum();
    }
}

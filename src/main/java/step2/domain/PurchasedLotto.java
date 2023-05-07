package step2.domain;

import static step2.domain.Ranking.SECOND;
import static step2.domain.Ranking.THIRD;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchasedLotto {

    private final List<Lotto> purchasedLottoList;

    public PurchasedLotto(List<Lotto> purchasedLottoList) {
        this.purchasedLottoList = purchasedLottoList;
    }

    public PurchasedLotto() {
        purchasedLottoList = new ArrayList<>();
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

    public void applyRanking(WinningNumbers winningNumbers) {
        for (Lotto lotto : this.purchasedLottoList) {
            int matchedCount = getMatchedCount(winningNumbers, lotto);
            Ranking ranking = Ranking.match(matchedCount);
            lotto.rank(ranking);
        }
    }

    public void matchSecondOrThird(BonusNumber bonusNumber) {
        List<Lotto> secondCandidate =
            purchasedLottoList.stream().filter(Lotto::isSecond).collect(Collectors.toList());

        for (Lotto lotto : secondCandidate) {
            boolean isContained = bonusNumber.isContained(lotto);
            prizeSecondOrThird(lotto, isContained);
        }
    }


    public void addManualLotto(ManualLotto manualLotto) {
        purchasedLottoList.addAll(manualLotto.toLottoEntity());
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

    private long getSumOfWinningMoney() {
        return purchasedLottoList.stream().mapToInt(Lotto::getPrizedMoney).sum();
    }
}

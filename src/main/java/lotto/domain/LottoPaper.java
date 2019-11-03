package lotto.domain;

import lotto.Insights;

import java.util.ArrayList;
import java.util.List;

public class LottoPaper {
    private static final int LOTTO_VALUE = 1000;

    private List<Lotto> lottoPapers;

    public LottoPaper() {
        this.lottoPapers = new ArrayList<>();
    }

    public List<Lotto> getLottoPapers() {
        return lottoPapers;
    }

    public void applyLotto(Lotto lotto) {
        this.lottoPapers.add(lotto);
    }
    
    public void checkLottoGrade(int[] winLotto) {
        for (Lotto lotto : lottoPapers) {
            lotto.checkNumber(winLotto);
        }
    }

    public void getInsights() {
        for (Lotto lotto : lottoPapers) {
            int hitCount = lotto.getHitCount();
            checkInsights(hitCount);
        }
    }

    private void checkInsights(int hitCount) {
        if (Insights.insights.containsKey(hitCount)) {
            Insights.insights.get(hitCount).increaseCount();
        }
    }

    public double getYield(int purchaseCount) {
        int winnings = Insights.getTotalPrice();
        int purchasePrice = purchaseCount * LOTTO_VALUE;
        return (double)winnings/purchasePrice;
    }
}

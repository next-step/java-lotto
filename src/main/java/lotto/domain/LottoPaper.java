package lotto.domain;

import lotto.Insights;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoPaper {
    private static final int LOTTO_VALUE = 1000;

    private List<Lotto> lottoPapers;

    public LottoPaper() {
        this.lottoPapers = new ArrayList<>();
    }

    public LottoPaper(Integer count) {
        this.lottoPapers = new ArrayList<>();
        createLotto(count);
    }

    public List<Lotto> getLottoPapers() {
        return lottoPapers;
    }

    private void createLotto(int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            applyLotto(lotto);
        }
    }

    public void applyLotto(Lotto lotto) {
        this.lottoPapers.add(lotto);
    }
    
    public void checkLottoGrade(int[] winLotto) {
        for (Lotto lotto : lottoPapers) {
            lotto.checkNumber(winLotto);
        }
    }

    public Map<Integer, Insights> getInsights() {
        for (Lotto lotto : lottoPapers) {
            int hitCount = lotto.getHitCount();
            checkInsights(hitCount);
        }
        return Insights.insights;
    }

    public Map<Integer, Insights> checkInsights(int hitCount) {
        if (Insights.insights.containsKey(hitCount)) {
            Insights.insights.get(hitCount).increaseCount();
        }
        return Insights.insights;
    }

    public double getYield(int purchaseCount) {
        int winnings = Insights.getTotalPrice();
        int purchasePrice = purchaseCount * LOTTO_VALUE;
        return (double)winnings/purchasePrice;
    }
}

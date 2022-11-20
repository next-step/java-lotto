package lotto.numbers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.enums.Ranks;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(int purchaseCount) {
        this.lottoBundle = new ArrayList<>(purchaseCount);
        generateNumbers(purchaseCount);
    }

    public Map<Ranks, Integer> getRanks(List<Integer> winningNumbers, int bonusNumber) {
        Map<Ranks, Integer> rankingMap = new LinkedHashMap<>();
        for (Lotto lotto : lottoBundle) {
            Ranks rank = lotto.getRankOfNumbers(winningNumbers, bonusNumber);
            int count = rankingMap.getOrDefault(rank, 0);
            rankingMap.put(rank, count + 1);
        }
        return rankingMap;
    }

    public int getBundleSize() {
        return this.lottoBundle.size();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        lottoBundle.forEach(lotto -> {
            result.append(lotto.toString());
            result.append("\n");
        });
        return result.toString();
    }

    private void generateNumbers(int purchaseCount) {
        for (int i = 0 ; i < purchaseCount ; i++) {
            lottoBundle.add(new Lotto());
        }
    }
}

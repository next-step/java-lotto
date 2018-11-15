package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoComparator {
    private Map<LottoType, Integer> winnings = new HashMap<>();

    public Map<LottoType, Integer> getWinnings() {
        return winnings;
    }

    public void comparate(List<Lotto> purchasLottos, Set<Integer> winningNumber) {
        for (Lotto lotto : purchasLottos) {
            lotto.countbyComparingNumbers(winningNumber);
            increaseWinningCount(lotto);
        }
    }

    private void increaseWinningCount(Lotto lotto) {
        if (lotto.isWinning()) {
            LottoType lottoType = lotto.findLottoType();
            winnings.compute(lottoType, (key, winningCount) -> winningCount == null ? 1 : winningCount + 1);
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (LottoType lottoType : LottoType.values()) {
            int winningCount = winnings.getOrDefault(lottoType, 0);
            buffer.append(lottoType + "- " + winningCount + "개\n");
        }
        return buffer.toString();
    }
}
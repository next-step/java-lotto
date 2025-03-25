package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult = new HashMap<>();

    public void addLottoResult(Lotto purchasedLotto, Lotto winningLotto) {
        LottoRank rank = purchasedLotto.getRank(winningLotto);

        if (rank == null) return;

        lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (LottoRank rank : LottoRank.values()) {
            int count = lottoResult.getOrDefault(rank, 0);
            String message = String.format("%d개 일치 (%d원)- %d개\n", rank.getNumOfMatch(), rank.getPrize(), count);
            sb.append(message);
        }

        return sb.toString();
    }
}

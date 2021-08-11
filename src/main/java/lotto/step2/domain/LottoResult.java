package lotto.step2.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LottoResult {
    private Map<WinningRank, Integer> lottoResult;
    private LottoTicket winningNumber;

    public LottoResult(LottoTicket winningNumber) {
        this.lottoResult = new HashMap<>();
        this.winningNumber = winningNumber;
    }

    public Map<WinningRank, Integer> checkLottoTicket(LottoTicket lottoTicket) {
            int matchCount = lottoTicket.matchWinningNumber(winningNumber);
            checkWinningRank(matchCount);

        return lottoResult;
    }

    public Map<WinningRank, Integer> getLottoResult() {
        return lottoResult;
    }

    private void checkWinningRank(int matchCount) {
        if (matchCount == WinningRank.FOURTH_PLACE.getMatchCount()) {
            lottoResult.put(WinningRank.FOURTH_PLACE, lottoResult.getOrDefault(WinningRank.FOURTH_PLACE, 0) + 1);
            return;
        }

        if (matchCount == WinningRank.THIRD_PLACE.getMatchCount()) {
            lottoResult.put(WinningRank.THIRD_PLACE, lottoResult.getOrDefault(WinningRank.THIRD_PLACE, 0) + 1);
            return;
        }

        if (matchCount == WinningRank.SECOND_PLACE.getMatchCount()) {
            lottoResult.put(WinningRank.SECOND_PLACE, lottoResult.getOrDefault(WinningRank.SECOND_PLACE, 0) + 1);
            return;
        }

        if (matchCount == WinningRank.FIRST_PLACE.getMatchCount()) {
            lottoResult.put(WinningRank.FIRST_PLACE, lottoResult.getOrDefault(WinningRank.FIRST_PLACE, 0) + 1);
            return;
        }
    }

    public double calculateStatistics(int price) {
        Iterator<WinningRank> iterator = lottoResult.keySet().iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            WinningRank winningRank = iterator.next();
            sum += winningRank.getWinnings() * lottoResult.get(winningRank);
        }
        return sum / (double) price;
    }

}

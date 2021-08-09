package lotto.step2.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LottoResult {

    private static final Map<WinningRank, Integer> lottoResult = new HashMap<>();


    public static Map<WinningRank,Integer> checkLottoTicket(WinningNumber winningNumber, Lotto lotto) {
        for (LottoTicket lottoTicket : lotto.getLotto()) {
            int matchCount = lottoTicket.matchWinningNumber(winningNumber);
            checkWinningRank(matchCount);
        }
        return lottoResult;
    }

    private static void checkWinningRank(int matchCount) {
        if (matchCount == 3) {
            lottoResult.put(WinningRank.FOURTH_PLACE, lottoResult.getOrDefault(WinningRank.FOURTH_PLACE, 0) + 1);
        }

        if (matchCount == 4) {
            lottoResult.put(WinningRank.THIRD_PLACE, lottoResult.getOrDefault(WinningRank.THIRD_PLACE, 0) + 1);
        }

        if (matchCount == 5) {
            lottoResult.put(WinningRank.SECOND_PLACE, lottoResult.getOrDefault(WinningRank.SECOND_PLACE, 0) + 1);
        }

        if (matchCount == 6) {
            lottoResult.put(WinningRank.FIRST_PLACE, lottoResult.getOrDefault(WinningRank.FIRST_PLACE, 0) + 1);
        }
    }

    public static double calculateStatistics(int price) {
        Iterator<WinningRank> iterator = lottoResult.keySet().iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            WinningRank winningRank = iterator.next();
            sum += winningRank.getWinnings()*lottoResult.get(winningRank);
        }
        return sum / (double)price;
    }

}

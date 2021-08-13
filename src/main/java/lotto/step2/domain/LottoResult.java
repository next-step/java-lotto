package lotto.step2.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int MULTIPLE_FIRST_PLACE_WINNING = 2;

    private Map<WinningRank, Integer> lottoResult;
    private LottoTicket winningNumber;


    public LottoResult(LottoTicket winningNumber) {
        this.lottoResult = new HashMap<>();
        this.winningNumber = winningNumber;
    }

    public LottoResult() {
        this.lottoResult = new HashMap<>();
    }

//    public void matchLotto2(LottoTicket winningNumber) {
//        for (LottoTicket lottoTicket : this.lotto) {
//            lottoResult.checkLottoTicket(lottoTicket);
//        }
//    }

    public void checkLottoTicket(LottoTicket lottoTicket) {
        int matchCount = lottoTicket.matchWinningNumber(winningNumber);
        checkWinningRank(matchCount);
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
        long sum = 0;
        for (WinningRank rank : WinningRank.values()) {
            sum += addLottoWinnings(rank);
        }
        return sum / (double) price;
    }

    public int addLottoWinnings(WinningRank winningRank) {
        if (winningRank.toString().equals("FIRST_PLACE")) {
            return winFirstRank(winningRank);
        }
        return winningRank.getWinnings() * lottoResult.getOrDefault(winningRank, 0);
    }

    public int winFirstRank(WinningRank winningRank) {
        if (lottoResult.getOrDefault(winningRank, 0) >= MULTIPLE_FIRST_PLACE_WINNING) {
            return winningRank.getWinnings();
        }
        return winningRank.getWinnings() * lottoResult.getOrDefault(winningRank, 0);
    }

}

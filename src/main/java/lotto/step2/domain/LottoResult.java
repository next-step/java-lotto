package lotto.step2.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<WinningRank, Integer> lottoResult = new HashMap<>();


    public static void checkLottoTicket(WinningNumber winningNumber, Lotto lotto) {
        for (LottoTicket lottoTicket : lotto.getLotto()) {
            int matchCount = lottoTicket.matchWinningNumber(winningNumber);

        }
    }
    public static void checkWinningRank(int matchCount) {

    }

}

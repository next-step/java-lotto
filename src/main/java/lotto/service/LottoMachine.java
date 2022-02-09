package lotto.service;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;

public class LottoMachine {

    private static List<LottoResult> results;

    public static void run(List<LottoTicket> lottoTickets, List<WinningNumber> winningNumbers) {
        WinningResult winningResult = new WinningResult(lottoTickets, winningNumbers);
        results = winningResult.getTotalLottoResult();
    }

    public static List<LottoResult> getResults() {
        return results;
    }
}

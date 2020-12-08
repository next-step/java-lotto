package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningCondition;

import java.util.List;

public class LottoResultReader {
    private final ConsoleView consoleView;

    public LottoResultReader(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void readResult(List<LottoTicket> lottoTickets) {
        WinningCondition winningCondition = WinningCondition.of(consoleView.getWinningNumbers(), consoleView.getBonusNumber());
        LottoResult lottoResult = LottoResult.getLottoResult(lottoTickets, winningCondition);
        consoleView.printLottoResult(lottoResult);
    }
}

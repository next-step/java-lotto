package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameService {
    private LottoTickets lottoTickets;
    private WinningNumber winningNumbers;

    public LottoGameService() {
    }

    private LottoGameService(LottoTickets lottoTickets, WinningNumber winningNumbers) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
    }

    public static LottoGameService of(LottoTickets lottoTickets, WinningNumber winningNumbers) {
        return new LottoGameService(lottoTickets, winningNumbers);
    }

    public static LottoGameService from() {
        return new LottoGameService();
    }

    public void buyTickets() {
        int money = InputView.inputMoney();
        lottoTickets = lottoTickets.buyTickets(money);
        ResultView.printTickets(lottoTickets);
    }

    public void inputWinningNumber() {
        winningNumbers = InputView.inputWinningNumber();
    }

    public void makeLotteryResult() {
        ResultView.printWinningStatus(Prize.winningStatus(lottoTickets, winningNumbers));
        ResultView.printReturnRate(Prize.returnRate(lottoTickets, winningNumbers));
    }
}

package lotto;

import lotto.domain.*;
import lotto.utils.LottoLotteryUtils;
import lotto.utils.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.PrintView;

import java.util.List;

public class LottoGame {

    private final InputView inputView = new InputView();
    private final PrintView printView = new PrintView();

    public static void main(String[] args) {
        new LottoGame().start();
    }

    private void start() {
        LottoWallet lottoWallet = buyLotto();

        lottery(lottoWallet.lottoTickets());
    }

    private LottoWallet buyLotto() {
        LottoWallet lottoWallet = buyLottoTickets();
        printView.showStatusBuyTicket(lottoWallet);
        return lottoWallet;
    }

    private void lottery(List<LottoTicket> lottoTickets) {
        WinnerNumbers winnerNumbers = generatorWinnerNumber();

        WinnerStatistics winnerStatistics = LottoLotteryUtils.lotteryThisWeek(lottoTickets, winnerNumbers);

        printView.showLottoResult(winnerStatistics);
    }

    private WinnerNumbers generatorWinnerNumber() {
        List<String> inputWinnerNumbers = inputView.inputWinnerNumber();

        List<LottoNumber> lottoNumbers = LottoNumberGenerator.manualGenerator(inputWinnerNumbers);

        WinnerNumbers winnerNumbers = WinnerNumbers.create(lottoNumbers);

        return winnerNumbers;
    }

    private LottoWallet buyLottoTickets() {
        Money money = inputView.amountMoneyOfBuyTicket();

        LottoWallet lottoWallet = LottoWallet.create(money);
        lottoWallet.buyLotto();
        return lottoWallet;
    }
}

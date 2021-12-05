package lotto;

import lotto.domain.*;
import lotto.view.TerminalInputView;
import lotto.view.TerminalOutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        TerminalInputView inputView = new TerminalInputView();
        TerminalOutputView outputView = new TerminalOutputView();

        LottoPrice lottoPrice = lottoPrice(inputView, outputView);
        LottoResult lottoResult = lottoResult(inputView, outputView, lottoPrice);
        outputView.printLottoResult(lottoResult);
    }

    private static LottoPrice lottoPrice(TerminalInputView inputView, TerminalOutputView outputView) {
        outputView.printPurchaseAmountGuide();
        int purchaseAmount = inputView.purchaseAmount();
        return new LottoPrice(purchaseAmount);
    }

    private static LottoResult lottoResult(TerminalInputView inputView,
                                           TerminalOutputView outputView,
                                           LottoPrice lottoPrice) {
        LottoResult lottoResult = new LottoResult(
                myLottoTickets(lottoPrice, outputView),
                lottoWinningTicket(inputView, outputView));
        lottoResult.countPrize();
        return lottoResult;
    }

    private static MyLottoTickets myLottoTickets(LottoPrice lottoPrice, TerminalOutputView outputView) {
        MyLottoTickets myLottoTickets = new MyLottoTickets(lottoPrice);
        myLottoTickets.buy();
        outputView.printLottoTickets(myLottoTickets.lottoTickets());
        return myLottoTickets;
    }

    private static LottoTicket lottoWinningTicket(TerminalInputView inputView, TerminalOutputView outputView) {
        outputView.printWinningNumbersGuide();
        List<Integer> winningNumbers = inputView.lottoWinningNumbers();
        return LottoTicket.customLottoTicket(winningNumbers.stream()
                .mapToInt(n -> n)
                .toArray());
    }
}

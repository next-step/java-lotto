package lotto;

import lotto.domain.MyLottoTickets;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;
import lotto.view.TerminalInputView;
import lotto.view.TerminalOutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        TerminalInputView inputView = new TerminalInputView();
        TerminalOutputView outputView = new TerminalOutputView();

        LottoPrice lottoPrice = lottoPrice(inputView, outputView);
        MyLottoTickets myLottoTickets = lotto(lottoPrice, outputView);
        LottoTicket lottoWinningTicket = lottoWinningTicket(inputView, outputView);
    }

    private static LottoPrice lottoPrice(TerminalInputView inputView, TerminalOutputView outputView) {
        outputView.printPurchaseAmountGuide();
        int purchaseAmount = inputView.purchaseAmount();
        return new LottoPrice(purchaseAmount);
    }

    private static MyLottoTickets lotto(LottoPrice lottoPrice, TerminalOutputView outputView) {
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

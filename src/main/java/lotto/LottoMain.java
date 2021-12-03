package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;
import lotto.view.TerminalInputView;
import lotto.view.TerminalOutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        TerminalInputView inputView = new TerminalInputView();
        TerminalOutputView outputView = new TerminalOutputView();

        int numberOfTicket = numberOfTicket(inputView, outputView);
        Lotto lotto = lotto(numberOfTicket, outputView);
        LottoTicket lottoWinningTicket = lottoWinningTicket(inputView, outputView);
    }

    private static int numberOfTicket(TerminalInputView inputView, TerminalOutputView outputView) {
        outputView.printPurchaseAmountGuide();
        int purchaseAmount = inputView.purchaseAmount();
        LottoPrice lottoPrice = new LottoPrice(purchaseAmount);
        return lottoPrice.numberOfTicket();
    }

    private static Lotto lotto(int numberOfTicket, TerminalOutputView outputView) {
        Lotto lotto = new Lotto(numberOfTicket);
        outputView.printLottoTickets(lotto.myLottoTickets());
        return lotto;
    }

    private static LottoTicket lottoWinningTicket(TerminalInputView inputView, TerminalOutputView outputView) {
        outputView.printWinningNumbersGuide();
        List<Integer> winningNumbers = inputView.lottoWinningNumbers();
        return LottoTicket.customLottoTicket(winningNumbers.stream()
                .mapToInt(n -> n)
                .toArray());
    }
}

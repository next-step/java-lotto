package step2;

import step2.domain.LottoResult;
import step2.domain.LottoTicket;
import step2.domain.WinningNumbers;
import step2.domain.lottomachine.LottoMachine;
import step2.domain.lottomachine.RandomLottoMachine;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        int money = InputView.inputPurchaseMoney();
        int amount = OutputView.getPurchaseAmount(money);

        LottoMachine lottoMachine = new RandomLottoMachine();
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            LottoTicket lottoTicket = lottoMachine.issueLottoTicket();
            lottoTickets.add(lottoTicket);
        }
        OutputView.showBuyTickets(lottoTickets);

        List<Integer> winNumbers = InputView.inputWinningNumbers();
        Integer bonusNumber = InputView.inputBonusNumber(winNumbers);

        winNumbers.add(bonusNumber);
        WinningNumbers winningNumbers = new WinningNumbers(winNumbers);

        LottoResult lottoResult = new LottoResult(winningNumbers, lottoTickets);
        OutputView.showResult(lottoResult);
    }
}

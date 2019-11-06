package step2;

import step2.domain.LottoResult;
import step2.domain.LottoTicket;
import step2.domain.WinningNumbers;
import step2.domain.lottomachine.LottoMachine;
import step2.domain.lottomachine.ManualLottoMachine;
import step2.domain.lottomachine.RandomLottoMachine;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;

public class LottoController {

    public static void main(String[] args) {
        int money = InputView.inputPurchaseMoney();
        int amount = OutputView.getPurchaseAmount(money);

        LottoMachine manualLottoMachine = new ManualLottoMachine();
        LottoMachine RandomLottoMachine = new RandomLottoMachine();
        List<LottoTicket> lottoTickets = new ArrayList<>();

        Integer manualAmount = InputView.inputManualAmount(money);
        for (List<Integer> manualNumber : InputView.inputManualNumbers(manualAmount)) {
            LottoTicket lottoTicket = manualLottoMachine.issueLottoTicket(manualNumber);
            lottoTickets.add(lottoTicket);
        }

        for (int i = 0; i < amount - manualAmount; i++) {
            LottoTicket lottoTicket = RandomLottoMachine.issueLottoTicket(EMPTY_LIST);
            lottoTickets.add(lottoTicket);
        }
        OutputView.showBuyTickets(lottoTickets, manualAmount);

        List<Integer> winNumbers = InputView.inputWinningNumbers();
        Integer bonusNumber = InputView.inputBonusNumber(winNumbers);

        winNumbers.add(bonusNumber);
        WinningNumbers winningNumbers = new WinningNumbers(winNumbers);

        LottoResult lottoResult = new LottoResult(winningNumbers, lottoTickets);
        OutputView.showResult(lottoResult);
    }
}

package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.view.LottoMachineResultView;
import lotto.view.LottoMachineInputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        String money = LottoMachineInputView.lottoPurchaseView();
        LottoTickets lottoTickets = new LottoMachine().purchaseTicket(money);
        LottoMachineResultView.showTicketNumber(lottoTickets);

        List<Integer> winningNumbers = LottoMachineInputView.latestWinningLotto();
        int bonusNumber = LottoMachineInputView.bonusLottoNumber();
        LottoTicket winningLottoTicket = new LottoTicket(winningNumbers);

        LottoResult lottoResult = LottoMachineInputView.checkWinningResult(winningLottoTicket, lottoTickets,bonusNumber);

        LottoMachineResultView.printLottoResult(lottoResult);

    }
}

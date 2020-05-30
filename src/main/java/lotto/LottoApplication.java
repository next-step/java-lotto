package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.vo.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMoney lottoMoney = InputView.inputPurchaseAmount();

        OutputView.printNumberOfTicket(lottoMoney);

        List<LottoTicket> lottoTickets = LottoMachine.purchaseLottoTicket(lottoMoney);

        OutputView.printLottoTickets(lottoTickets);

        List<Integer> winningNumbers = InputView.inputLastWinningNumbers();
    }
}
